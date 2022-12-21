package com.ks.eshop.dao;

import com.ks.eshop.pojo.FunctionMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FunctionMenuDao {
    //增加一条记录
    @Insert("insert into function_menu(parent_id,fc_name,fc_url) values(#{parentId},#{fcName},#{fcUrl})")
    int insert(FunctionMenu function_menu);

    //根据id删除记录
    @Delete("delete from function_menu where id=#{id}")
    int deleteById(int id);

    //根据id查询记录
    @Select("select * from function_menu where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "parentId",column = "parent_id"),
            @Result(property = "fcName",column = "fc_name")
    })
    FunctionMenu queryById(int id);

    //根据parent_id查询记录
    @Select("select * from function_menu where parent_id=#{parentId} and status=1")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "parentId",column = "parent_id"),
            @Result(property = "fcName",column = "fc_name"),
    })
    FunctionMenu queryByParentId(int parentId);

    //查询所有记录
    @Select("select * from function_menu where parent_id = 0 and status=1  order by seq ASC ")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "parentId",column = "parent_id"),
            @Result(property = "fcName",column = "fc_name"),
            @Result(property = "childMenu",column = "id",many =
            @Many(select = "com.ks.eshop.dao.FunctionMenuDao.queryByParentId")),
    })
    List<FunctionMenu> queryAll();

    //根据id修改记录
    @Update("update function_menu set parent_id=#{parentId},fc_name=#{fcName},fc_url=#{fcUrl} where id=#{id}")
    int updateById(FunctionMenu function_menu);

    //分页查询所有功能记录
    @Select("select * from function_menu order by seq DESC")
    List<FunctionMenu> queryAlls();

    //查询总记录数
    @Select("select count(*) from function_menu")
    int queryCounts();

    //根据id修改状态
    @Update("update function_menu set status=#{status} where id =#{id}")
    int updateStatusById(@Param("id") Integer id,@Param("status") char status);
}
