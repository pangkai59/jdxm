package com.jdxm.common.base;


import com.jdxm.utils.Md5Utils;
import com.jdxm.utils.TimeUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class FileUploader {

    @Value("${file.root.dir}")
    private String fileRootDir;

    private String defaultValidFileTypes = "jpg,gif,jpeg,bmp,png,doc,docx,xls,xlsx,rar,zip,mp4,wnv,avi,rmvb";

    private Logger logger = LoggerFactory.getLogger(FileUploader.class);

    public FileUploader() {
    }

    public List<UpFile> save(HttpServletRequest request, String validFileTypes) {
        return _save(request, validFileTypes, null);
    }

    public List<UpFile> save(HttpServletRequest request) {
        return _save(request, defaultValidFileTypes, null);
    }

    public List<UpFile> saveByName(HttpServletRequest request, String validFileTypes, String name) {
        return _save(request, validFileTypes, name);
    }

    public List<UpFile> saveByName(HttpServletRequest request, String name) {
        return _save(request, defaultValidFileTypes, name);
    }

    /**
     * 保存上传的文件
     *
     * @param request
     * @param validFileTypes
     * @param name           文件对应的表单键
     * @return
     * @throws Exception
     */
    public List<UpFile> _save(HttpServletRequest request, String validFileTypes, String name) {
        Collection<Part> parts;
        try {
            parts = request.getParts();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("上传失败，获取请求失败");
        }

        String subDir = TimeUtils.date(String.format("yyyy%sMM%sdd", File.separator, File.separator));
        String dir = String.format("%s%s%s", fileRootDir, File.separator, subDir);
        File f = new File(dir);
        if (!f.exists()) {
            f.mkdirs();
        }
        // 把dir赋值成规范的绝对路径，不然后面part.write时，会写到相对tomcat根目录里去
        try {
            dir = f.getCanonicalPath();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("上传失败，获取保存目录失败");
        }

        List<UpFile> files = new ArrayList<>();
        for (Part part : parts) {
            String fn = part.getSubmittedFileName();
            if (fn == null || fn.equals("")) {
                continue;
            }

            if (name != null && !name.isEmpty()) {
                // 有指定的文件
                if (!name.equals(part.getName())) {
                    continue;
                }
            }

            if (!isValidFileType(fn, validFileTypes)) {
                logger.info(String.format("错误格式:%s", fn));
                throw new RuntimeException(String.format("上传失败，不支持该文件格式[%s]", fn));
            }
            if (part.getSize() > 5242880) {
                throw new RuntimeException("上传失败，图片大小超过限制");
            }
            InputStream in;
            try {
                in = part.getInputStream();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("上传失败，获取单个文件失败");
            }

            String md5;
            try {
                md5 = Md5Utils.fileMd5(in);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("上传失败，生成文件MD5失败");
            }

            String ext = FilenameUtils.getExtension(fn);
            if (ext == null || ext.isEmpty()) {
                ext = "none";
            }

            String path = String.format("%s%s%s.%d.%s", dir, File.separator, md5, System.currentTimeMillis(), ext);

            try {
                part.write(path);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("上传失败，写入文件失败");
            }

            files.add(new UpFile(md5, path, part.getSize(), fn, part.getContentType()));
        }

        return files;
    }

    /**
     * 判断上传的文件是不是符合指定的类型
     *
     * @param fn
     * @param validFileTypes
     * @return
     */
    protected boolean isValidFileType(String fn, String validFileTypes) {
        String[] types = validFileTypes.split(",");
        String ext = FilenameUtils.getExtension(fn);
        if (ext == null) {
            return false;
        }
        ext = ext.toLowerCase();
        return Arrays.asList(types).contains(ext);
    }


    public static String fileToBase64(HttpServletRequest request) throws Exception {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        Collection<Part> parts = request.getParts();
        byte[] data = null;
        // 读取图片字节数组
        try {
            for (Part part : parts) {
                if (part.getSubmittedFileName() == null) {
                    continue;
                }
                InputStream inputStream = part.getInputStream();
                data = new byte[inputStream.available()];
                inputStream.read(data);
                inputStream.close();
                // 对字节数组Base64编码
                BASE64Encoder encoder = new BASE64Encoder();
                return encoder.encode(data);// 返回Base64编码过的字节数组字符串
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    public UpFile toFile(String base64Code, String name) throws Exception {

        String subDir = TimeUtils.date(String.format("yyyy%sMM%sdd", File.separator, File.separator));
        String dir = String.format("%s%s%s", fileRootDir, File.separator, subDir);
        File f = new File(dir);
        if (!f.exists()) {
            f.mkdirs();
        }
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        String md5 = Md5Utils.fileMd5(buffer);
        String ext = "docx";
        String path = String.format("%s%s%s.%d.%s", dir, File.separator, md5, System.currentTimeMillis(), ext);
        UpFile file = new UpFile(md5, path, buffer.length, name + "." + ext, "application/msword");
        FileOutputStream out = new FileOutputStream(path);

        out.write(buffer);
        out.close();
        return file;
    }


}
