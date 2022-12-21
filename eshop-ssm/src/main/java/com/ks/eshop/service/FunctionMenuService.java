package com.ks.eshop.service;

import com.ks.eshop.pojo.FunctionMenu;

import java.util.List;

public interface FunctionMenuService {
    //增加一条记录
    int insert(FunctionMenu function_menu);

    //根据id删除记录
    int deleteById(int id);

    //根据id查询记录
    FunctionMenu queryById(int id);

    //查询所有记录
    List<FunctionMenu> queryAll();

    //根据id修改记录
    int updateById(FunctionMenu function_menu);

    //查询所有功能记录
    List<FunctionMenu> queryAlls();

    int queryCounts();

    //根据id修改状态
    int updateStatusById(Integer id,char status);
}
