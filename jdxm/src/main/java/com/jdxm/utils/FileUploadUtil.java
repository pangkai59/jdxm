package com.jdxm.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class FileUploadUtil {

    private static String defaultValidFileTypes = "jpg,jpeg,png,pdf,psd,bmp," +
            "mp3,wma,rm,wav,midi,ape,flac,ogg," +
            "avi,rmvb,asf,divx,mpg,mpeg,mpe,wmv,mp4,mkv,vob";

    /**
     * 返回文件上传的绝对路径
     *
     * @param baseDir 文件绝对路径
     * @param file    文件
     * @return String 文件上传的绝对路径
     * @throws IOException IOException
     */
    public static String generatingFileUploadPath(String baseDir, MultipartFile file) throws IOException {
        // 判断文件类型
        String type = null;// 文件类型
        String fileName = file.getOriginalFilename();// 文件原名称
        type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
        if (type == null) {// 判断文件类型是否为空
            throw new IOException();
        }
        if (isValidFileType(type, defaultValidFileTypes)) {
            SimpleDateFormat dateFormater = new SimpleDateFormat(String.format("yyyy%sMM%sdd", File.separator, File.separator));
            /*String path = System.getProperty("java.class.path");
            int firstIndex = path.lastIndexOf(System.getProperty("path.separator")) + 1;
            int lastIndex = path.lastIndexOf(File.separator) + 1;
            path = path.substring(firstIndex, lastIndex);*/
            String dir = String.format("%s%s%s", baseDir, File.separator, dateFormater.format(new Date()));
            File f = new File(dir);
            if (!f.exists()) {
                f.mkdirs();
            }

            if (null != file.getOriginalFilename()
                    && !"".equals(file.getOriginalFilename().trim())
                    && !"null".equals(file.getOriginalFilename().trim())) {
                String filename = System.currentTimeMillis() + "." + file.getOriginalFilename();
                dir = f.getCanonicalPath() + File.separator + filename;
                File upload = new File(dir);
                file.transferTo(upload);
            } else {
                throw new IOException();
            }

            return dir;
        } else {
            throw new IOException();
        }
    }


    /**
     * 判断上传的文件类型是不是符合指定的类型
     *
     * @param fileType
     * @param validFileTypes
     * @return
     */
    private static boolean isValidFileType(String fileType, String validFileTypes) {
        if (fileType == null) {
            return false;
        }

        String[] types = validFileTypes.split(",");
        fileType = fileType.toLowerCase();
        return Arrays.asList(types).contains(fileType);
    }

}
