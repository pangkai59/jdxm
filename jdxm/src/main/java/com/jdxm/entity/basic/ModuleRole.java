package com.jdxm.entity.basic;

public class ModuleRole {
    private Integer rid;

    private Integer mid;

    public ModuleRole(Integer rid, Integer mid) {
        this.rid = rid;
        this.mid = mid;
    }

    public ModuleRole() {
        super();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}