package com.ks.eshop.dao;

import com.ks.eshop.pojo.AdminInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminInfoDao {
    //增加一条记录
    @Insert("insert into admin_info(admin_name,admin_pwd) values(#{adminName},#{adminPwd})")
    @Options(keyProperty = "id",useGeneratedKeys = true)
    int insert(AdminInfo admin_info);

    //根据id删除记录
    @Delete("delete from admin_info where id=#{id}")
    int deleteById(int id);

    //根据id查询记录
    @Select("select * from admin_info where id=#{id}")
    @Results({
            @Result(property="id",column ="id"),
            @Result(property="permissions",column ="id",many =
            @Many(select = "com.ks.eshop.dao.PermissionDao.queryByAid"))
    })
    AdminInfo queryById(int id);

    //根据登录名和密码查询用户
    @Select("select * from admin_info where admin_name=#{adminName} and admin_pwd=#{adminPwd} and status = '1'")
    AdminInfo queryByNameAndPwd(@Param("adminName") String adminName,@Param("adminPwd") String adminPwd);

    //查询所有记录
    @Select("select * from admin_info")
    @Results({
            @Result(property="id",column ="id"),
            @Result(property="permissions",column ="id",many =
            @Many(select = "com.ks.eshop.dao.PermissionDao.queryByAid"))
    })
    List<AdminInfo> queryAll();

    //根据id修改记录
    @Update("update admin_info set admin_name=#{adminName},admin_pwd=#{adminPwd} where id=#{id}")
    int updateById(AdminInfo admin_info);

    //根据id修改状态
    @Update("update admin_info set status = #{status} where id = #{id}")
    int updateStatus(@Param("id")Integer id,@Param("status")char status);
}
