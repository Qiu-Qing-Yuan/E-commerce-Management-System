package com.ks.eshop.dao;

import com.ks.eshop.pojo.ProductInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductInfoDao {
    //增加一条记录
    @Insert("insert into product_info(pd_code,pd_name,tid,brand,image,price,num,remark) values(#{pdCode},#{pdName},#{tid},#{brand},#{image},#{price},#{num},#{remark})")
    int insert(ProductInfo product_info);

    //根据id删除记录
    @Delete("delete from product_info where id=#{id}")
    int deleteById(int id);

    //根据id查询记录
    @Select("select * from product_info where id=#{id}")
    ProductInfo queryById(int id);

    //查询所有记录
    @Select("select * from product_info")
    @Results(
            @Result(property = "type",column = "tid",one =
            @One(select = "com.ks.eshop.dao.ProductTypeDao.queryById"))
    )
    List<ProductInfo> queryAll();

    //根据id修改记录
    @Update("update product_info set pd_code=#{pdCode},pd_name=#{pdName},tid=#{tid},brand=#{brand},image=#{image},price=#{price},num=#{num},remark=#{remark},status=#{status} where id=#{id}")
    int updateById(ProductInfo product_info);

    //分页查询所有功能记录
    @Select("select * from product_info limit #{offset},#{size}")
    @Results(
            @Result(property = "type",column = "tid",one =
            @One(select = "com.ks.eshop.dao.ProductTypeDao.queryById"))
    )
    List<ProductInfo> queryByPage(@Param("offset") int offset, @Param("size") int size);

    //查询总记录数
    @Select("select count(*) from product_info")
    int queryCounts();

    //根据条件查询结果
    List<ProductInfo> queryByCondition(ProductInfo productInfo);
}
