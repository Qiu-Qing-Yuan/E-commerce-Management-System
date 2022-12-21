package com.ks.eshop.dao;

import com.ks.eshop.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoDao {
    //增加一条记录
    @Insert("insert into user_info(user_name,user_pwd,real_name,sex,email,address) values(#{userName},#{userPwd},#{realName},#{sex},#{email},#{address})")
    int insert(UserInfo user_info);

    //根据id删除记录
    @Delete("delete from user_info where id=#{id}")
    int deleteById(int id);

    //根据id查询记录
    @Select("select * from user_info where id=#{id}")
    UserInfo queryById(int id);

    //分页查询所有记录
    @Select("select * from user_info limit #{startIoc} , #{size}")
    List<UserInfo> queryAll(@Param("startIoc")int startIoc,@Param("size")int size);

    //查询所有记录
    @Select("select * from user_info")
    List<UserInfo> queryAlls();
    //根据id修改记录
    @Update("update user_info set user_name=#{userName},user_pwd=#{userPwd},real_name=#{realName},sex=#{sex},email=#{email},address=#{address} where id=#{id}")
    int updateById(UserInfo user_info);

    //根据id修改用户状态
    @Update("update user_info set status=#{status} where id = #{id}")
    int updateStatusById(@Param("id") int id,@Param("status") char status);

    //根据条件查询
    List<UserInfo> query(UserInfo userInfo);

    //查询总记录数
    @Select("select count(*) from user_info")
    int queryCounts();
}
