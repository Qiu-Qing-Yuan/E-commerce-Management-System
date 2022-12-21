package com.ks.eshop.service.impl;

import com.ks.eshop.dao.AdminInfoDao;
import com.ks.eshop.pojo.AdminInfo;
import com.ks.eshop.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("adminInfoService")
public class AdminInfoServiceImpl implements AdminInfoService {
    @Autowired
    private AdminInfoDao adminInfoDao;

    @Override
    public AdminInfo insert(AdminInfo admin_info) {
        adminInfoDao.insert(admin_info);
        return admin_info;
    }

    @Override
    public int deleteById(int id) {
        return adminInfoDao.deleteById(id);
    }

    @Override
    public AdminInfo queryById(int id) {
        return adminInfoDao.queryById(id);
    }

    @Override
    public List<AdminInfo> queryAll() {
        return adminInfoDao.queryAll();
    }

    @Override
    public int updateById(AdminInfo admin_info) {
        return adminInfoDao.updateById(admin_info);
    }

    @Override
    public int updateStatus(Integer id, char status) {
        return adminInfoDao.updateStatus(id,status);
    }

    @Override
    public AdminInfo queryByNameAndPwd(String adminName, String adminPwd) {
        return adminInfoDao.queryByNameAndPwd(adminName,adminPwd);
    }
}
