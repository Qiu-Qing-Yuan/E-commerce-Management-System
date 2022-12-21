package com.ks.eshop.service;

import com.ks.eshop.pojo.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    //增加一条记录
    int insert(ProductInfo product_info);

    //根据id删除记录
    int deleteById(int id);

    //根据id查询记录
    ProductInfo queryById(int id);

    //查询所有记录
    List<ProductInfo> queryAll();

    //根据id修改记录
    int updateById(ProductInfo product_info);

    //分页查询所有功能记录
    List<ProductInfo> queryByPage(int offset,int size);

    //查询总记录数
    int queryCounts();

    //根据条件查询结果
    List<ProductInfo> queryByCondition(ProductInfo productInfo);
}
