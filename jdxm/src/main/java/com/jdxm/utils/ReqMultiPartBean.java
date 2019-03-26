package com.jdxm.utils;

import org.apache.commons.fileupload.FileItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MultiPart结构的请求，包括参数和文件
 * Created by qxh on 2016/6/16.
 */
public class ReqMultiPartBean {
    public Map<String, String> multiParams = new HashMap<String, String>(); //req请求参数组成的数组
    public List<FileItem> fileItemList = new ArrayList<FileItem>(); //req上传过来的文件列表
}
