package com.jdxm.common.base;

/**
 * Created by swk on 2017/2/15.
 */
public class UpFile {
    private Integer fid;
    private String path;
    private long size;
    private String name;
    private String type;
    private String md5;

    public UpFile(){

    }

    public UpFile(String md5, String path, long size, String name, String type) {
        this.md5 = md5;
        this.path = path;
        this.size = size;
        this.name = name;
        this.type = type;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getPath() {
        return path;
    }

    public long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getMd5() {
        return md5;
    }
}
