package com.ks.eshop.common;

import lombok.Data;
import java.io.Serializable;

@Data
public class Page implements Serializable {
    private Integer pageSize; //每一页记录数
    private Integer currentPage;// 当前页
    private Integer startIoc;// 当前页的起始位置
    private Integer total; //总数据数

    public Page(Integer currentPage,Integer pageSize) {
        this.pageSize = pageSize;//每一页多少数据
        this.currentPage = currentPage; //当前页数
        this.startIoc = (currentPage-1)*pageSize; //起始=每一页记录数*当前页数
    }
}
