package com.ks.eshop.service.impl;

import com.ks.eshop.dao.FunctionMenuDao;
import com.ks.eshop.pojo.FunctionMenu;
import com.ks.eshop.service.FunctionMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionMenuServiceImpl implements FunctionMenuService {
    @Autowired
    private FunctionMenuDao functionMenuDao;

    @Override
    public int insert(FunctionMenu function_menu) {
        return functionMenuDao.insert(function_menu);
    }

    @Override
    public int deleteById(int id) {
        return functionMenuDao.deleteById(id);
    }

    @Override
    public FunctionMenu queryById(int id) {
        return functionMenuDao.queryById(id);
    }

    @Override
    public List<FunctionMenu> queryAll() {
        return functionMenuDao.queryAll();
    }

    @Override
    public int updateById(FunctionMenu function_menu) {
        return functionMenuDao.updateById(function_menu);
    }

    @Override
    public List<FunctionMenu> queryAlls() {
        return functionMenuDao.queryAlls();
    }

    @Override
    public int queryCounts() {
        return functionMenuDao.queryCounts();
    }

    @Override
    public int updateStatusById(Integer id, char status) {
        return functionMenuDao.updateStatusById(id,status);
    }

}
