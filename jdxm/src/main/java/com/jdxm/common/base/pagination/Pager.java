package com.jdxm.common.base.pagination;


import com.jdxm.common.base.Constant;

public class Pager {
    private Integer page = Constant.PAGE_PAGE;
    private Integer size = Constant.PAGE_SIZE;
    private Integer start;

    public Pager() {}

    public Pager(Integer size, Integer page) {
        this.size = size;
        this.page = page;
    }

    public Integer getPage() {
        return page > 0 ? page : Constant.PAGE_PAGE;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size < 1 ? Constant.PAGE_SIZE : size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStart() {
        return (getPage() - 1) * getSize();
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return String.format("%s@[page=%d, size=%d, start=%d]", getClass().getName(), page, size, getStart());
    }
}
