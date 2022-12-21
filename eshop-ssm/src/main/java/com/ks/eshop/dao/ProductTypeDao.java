package com.ks.eshop.dao;

import com.ks.eshop.pojo.ProductType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductTypeDao {
    //增加一条记录
    @Insert("insert into product_type(type_name) values(#{typeName})")
    int insert(ProductType product_type);

    //根据id删除记录
    @Delete("delete from product_type where id=#{id}")
    int deleteById(int id);

    //根据id查询记录
    @Select("select * from product_type where id=#{id}")
    ProductType queryById(int id);

    //根据id查询记录
    @Select("select * from product_type where type_name=#{typeName}")
    ProductType queryByTypeName(String typeName);

    //查询所有记录
    @Select("select * from product_type")
    List<ProductType> queryAll();

    //根据id修改记录
    @Update("update product_type set type_name=#{typeName} where id=#{id}")
    int updateById(ProductType product_type);
}
