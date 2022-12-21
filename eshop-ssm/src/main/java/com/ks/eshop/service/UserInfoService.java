package com.ks.eshop.service;

import com.ks.eshop.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    //增加一条记录
    int insert(UserInfo user_info);

    //根据id删除记录
    int deleteById(int id);

    //根据id查询记录
    UserInfo queryById(int id);

    //查询所有记录
    List<UserInfo> queryAll(int startIoc,int size);

    //根据id修改记录
    int updateById(UserInfo user_info);

    //根据id修改用户状态
    int updateStatusById(int id,char status);

    //根据条件查询
    List<UserInfo> query(UserInfo userInfo);
    //查询总记录数
    int queryCounts();

    //查询所有记录
    List<UserInfo> queryAlls();
}
