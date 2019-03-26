package com.jdxm.entity.basic;

import java.io.Serializable;
import java.util.Date;

/**
 * User: PK
 * Date: 2019/3/26
 * Time: 9:18
 * Description:  操作日志
 */
public class SysLog implements Serializable {
    private Long id;

    private Integer userId; //用户ID

    private String url; //操作url

    private String method; //方法

    private String params; //参数

    private String ip; //url

    private Date createTime; //操作时间

    private Date updateTime; //编辑时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}