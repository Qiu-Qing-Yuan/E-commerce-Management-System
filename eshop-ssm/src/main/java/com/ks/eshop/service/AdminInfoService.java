package com.ks.eshop.service;

import com.ks.eshop.pojo.AdminInfo;

import java.util.List;

public interface AdminInfoService {
    //增加一条记录
    AdminInfo insert(AdminInfo admin_info);

    //根据id删除记录
    int deleteById(int id);

    //根据id查询记录
    AdminInfo queryById(int id);

    //查询所有记录
    List<AdminInfo> queryAll();

    //根据id修改记录
    int updateById(AdminInfo admin_info);
    //根据id修改状态
    int updateStatus(Integer id,char status);
    //根据登录名和密码查询用户
    AdminInfo queryByNameAndPwd(String adminName,String adminPwd);
}
