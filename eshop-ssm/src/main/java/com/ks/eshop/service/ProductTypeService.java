package com.ks.eshop.service;

import com.ks.eshop.pojo.ProductType;

import java.util.List;

public interface ProductTypeService {
    //增加一条记录
    int insert(ProductType product_type);

    //根据id删除记录
    int deleteById(int id);

    //根据id查询记录
    ProductType queryById(int id);

    //查询所有记录
    List<ProductType> queryAll();

    //根据id修改记录
    int updateById(ProductType product_type);

    //根据id查询记录
    ProductType queryByTypeName(String typeName);
}
