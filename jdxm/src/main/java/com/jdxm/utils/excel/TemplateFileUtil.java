package com.jdxm.utils.excel;

import org.springframework.core.io.ClassPathResource;

import java.io.*;


public class TemplateFileUtil {
    public static InputStream getTemplates(String tempName) throws IOException {
        String path = "excelTemplates" + File.separator + tempName;
        ClassPathResource classPathResource = new ClassPathResource(path);
        return classPathResource.getInputStream();
    }
}
