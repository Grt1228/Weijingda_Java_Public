package com.jgsu.vo;

import java.io.Serializable;

/**
 * 描述:
 * 抽象类分页相关
 *
 * @author grt
 * @create 2018-04-28 16:00
 */
public abstract class PageRequest implements Serializable {

    private Integer pageNum;
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}