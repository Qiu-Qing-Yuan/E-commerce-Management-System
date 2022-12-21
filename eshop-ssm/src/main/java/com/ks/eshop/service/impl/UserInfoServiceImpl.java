package com.ks.eshop.service.impl;

import com.ks.eshop.dao.UserInfoDao;
import com.ks.eshop.pojo.UserInfo;
import com.ks.eshop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public int insert(UserInfo user_info) {
        return userInfoDao.insert(user_info);
    }

    @Override
    public int deleteById(int id) {
        return userInfoDao.deleteById(id);
    }

    @Override
    public UserInfo queryById(int id) {
        return userInfoDao.queryById(id);
    }

    @Override
    public List<UserInfo> queryAll(int startIoc, int size) {
        return userInfoDao.queryAll(startIoc,size);
    }

    @Override
    public int updateById(UserInfo user_info) {
        return userInfoDao.updateById(user_info);
    }

    @Override
    public int updateStatusById(int id, char status) {
        return userInfoDao.updateStatusById(id,status);
    }

    @Override
    public List<UserInfo> query(UserInfo userInfo) {
        return userInfoDao.query(userInfo);
    }

    @Override
    public int queryCounts() {
        return userInfoDao.queryCounts();
    }

    @Override
    public List<UserInfo> queryAlls() {
        return userInfoDao.queryAlls();
    }
}
