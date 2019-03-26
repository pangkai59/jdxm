package com.jdxm.utils;

import com.alibaba.fastjson.JSON;
import com.jdxm.common.constant.StatusConstant;
import com.jdxm.common.exception.CodeRuntimeException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Http请求工具
 */
public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(180, TimeUnit.SECONDS)
            .build();

    public static String get(String url, String cid, String secret) {
        Request.Builder builder = new Request.Builder()
                .url(url);
        builder.addHeader("Authorization", secret);
        builder.addHeader("cid", cid);
        Call call = okHttpClient.newCall(builder.build());
        try {
            Response response = call.execute();
            String str = response.body().string();
            return str;
        } catch (IOException e) {
            throw new CodeRuntimeException(StatusConstant.ERR, url + "当前网络繁忙，请稍后重试");
        }
    }

    public static String get(String url, String token) {
        Request.Builder builder = new Request.Builder()
                .url(url);
        builder.addHeader("token", token);
        Call call = okHttpClient.newCall(builder.build());
        try {
            Response response = call.execute();
            String str = response.body().string();
            return str;
        } catch (IOException e) {
            throw new CodeRuntimeException(StatusConstant.ERR, url + "当前网络繁忙，请稍后重试");
        }
    }

    public static String delete(String url, String token) {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .delete();
        builder.addHeader("token", token);
        Call call = okHttpClient.newCall(builder.build());
        try {
            Response response = call.execute();
            String str = response.body().string();
            return str;
        } catch (IOException e) {
            throw new CodeRuntimeException(StatusConstant.ERR, url + "当前网络繁忙，请稍后重试");
        }
    }

    public static String get(String url) {
        Request.Builder builder = new Request.Builder()
                .url(url);
        Call call = okHttpClient.newCall(builder.build());
        try {
            Response response = call.execute();
            String str = response.body().string();
            return str;
        } catch (IOException e) {
            throw new CodeRuntimeException(StatusConstant.ERR, url + "当前网络繁忙，请稍后重试");
        }
    }

    public static String post(String url, String jsonBody, String cid, String secret) {
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), jsonBody);

        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);

        builder.addHeader("Authorization", secret);
        builder.addHeader("cid", cid);
        Call call = okHttpClient.newCall(builder.build());
        try {
            Response response = call.execute();
            String str = response.body().string();
            return str;
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CodeRuntimeException(StatusConstant.ERR, url + "当前网络繁忙，请稍后重试");
        }
    }

    public static String post(String url, String jsonBody) {
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), jsonBody);

        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);

        Call call = okHttpClient.newCall(builder.build());
        try {
            Response response = call.execute();
            String str = response.body().string();
            return str;
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CodeRuntimeException(StatusConstant.ERR, url + "当前网络繁忙，请稍后重试");
        }
    }

    /**
     * Form表单提交
     *
     * @param url  请求路径
     * @param data 表单键值对
     * @return response.body
     */
    public static String post(String url, Map<String, String> data) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getValue() != null) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }

        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();

        Call call = okHttpClient.newCall(request);

        try {
            Response response = call.execute();
            String str = response.body().string();
            return str;
        } catch (IOException e) {
            throw new RuntimeException("当前网络繁忙，请稍后重试");
        }
    }

    public static String post(String url, String jsonBody, String token) {
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), jsonBody);

        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);

        builder.addHeader("token", token);
        Call call = okHttpClient.newCall(builder.build());
        try {
            Response response = call.execute();
            String str = response.body().string();
            return str;
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CodeRuntimeException(StatusConstant.ERR, url + "当前网络繁忙，请稍后重试");
        }
    }


    public static String patch(String url, String jsonBody, String token) {
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), jsonBody);

        Request.Builder builder = new Request.Builder()
                .url(url)
                .patch(requestBody);

        builder.addHeader("token", token);
        Call call = okHttpClient.newCall(builder.build());
        try {
            Response response = call.execute();
            String str = response.body().string();
            return str;
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CodeRuntimeException(StatusConstant.ERR, url + "当前网络繁忙，请稍后重试");
        }
    }

    public static Map<String, String> post2(String url, String jsonBody) {
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), jsonBody);

        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);

        Call call = okHttpClient.newCall(builder.build());
        try {
            Response response = call.execute();
            String token = response.header("token");
            String str = response.body().string();

            Map<String, String> map = new HashMap<>();
            map.put("str", str);
            map.put("token", token);
            return map;
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CodeRuntimeException(StatusConstant.ERR, url + "当前网络繁忙，请稍后重试");
        }
    }

    public static String put(String url, String jsonBody) {
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), jsonBody);

        Request.Builder builder = new Request.Builder()
                .url(url)
                .put(requestBody);

        Call call = okHttpClient.newCall(builder.build());
        try {
            Response response = call.execute();
            String str = response.body().string();
            return str;
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CodeRuntimeException(StatusConstant.ERR, url + "当前网络繁忙，请稍后重试");
        }
    }

    /**
     * 下载文件 并返回文件保存路径
     *
     * @param url      下载链接地址
     * @param baseDir  文件绝对目录路径
     * @param fileName 下载下来的文件名称
     * @return String 文件保存路径
     */
    public static String downloadFile(String url, String baseDir, String fileName) {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();

        SimpleDateFormat dateFormater = new SimpleDateFormat(String.format("yyyy%sMM%sdd", File.separator, File.separator));
        /*String path = System.getProperty("java.class.path");
        int firstIndex = path.lastIndexOf(System.getProperty("path.separator")) + 1;
        int lastIndex = path.lastIndexOf(File.separator);
        path = path.substring(firstIndex, lastIndex);*/
        // 目的下载路径(不包含文件路径)
        String destFileDir = String.format("%s%s%s", baseDir, File.separator, dateFormater.format(new Date()));
        File f = new File(destFileDir);
        if (!f.exists()) {
            f.mkdirs();
        }

        final File file = new File(destFileDir, fileName);

        String filePath = destFileDir + File.separator + fileName;
        if (file.exists()) {
            return filePath;
        }

        Call call = okHttpClient.newCall(builder.build());
        try {
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    logger.error(e.getMessage(), e);
                    throw new RuntimeException(url + "当前网络繁忙，请稍后重试");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    InputStream is = null;
                    byte[] buf = new byte[2048];
                    int len;
                    FileOutputStream fos = null;
                    try {
                        is = response.body().byteStream();
                        fos = new FileOutputStream(filePath);
                        while ((len = is.read(buf)) != -1) {
                            fos.write(buf, 0, len);
                        }
                        fos.flush();
                    } catch (IOException e) {
                        logger.error(e.getMessage(), e);
                        throw new RuntimeException(url + "当前网络繁忙，请稍后重试");
                    } finally {
                        try {
                            if (is != null) {
                                is.close();
                            }
                            if (fos != null) {
                                fos.close();
                            }
                        } catch (IOException e) {
                            logger.error(e.getMessage(), e);
                            throw new CodeRuntimeException(StatusConstant.ERR, "当前网络繁忙，请稍后重试");
                        }
                    }
                }
            });
            return filePath;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new CodeRuntimeException(StatusConstant.ERR, url + "当前网络繁忙，请稍后重试");
        }
    }

    /**
     * 往响应中输出数据
     *
     * @param response ServletResponse
     * @param back     Object 需要附加的信息
     */
    public static void out(ServletResponse response, Object back) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        ServletOutputStream out;
        try {
            out = response.getOutputStream();
            String jsonStr = JSON.toJSONString(back);
            out.write(jsonStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
