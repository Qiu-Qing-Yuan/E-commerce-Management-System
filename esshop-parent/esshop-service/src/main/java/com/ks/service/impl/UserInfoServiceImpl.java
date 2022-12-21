package com.ks.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ks.dao.UserInfoMapper;
import com.ks.entity.UserInfo;
import com.ks.service.UserInfoService;
import com.ks.utils.PageHelper;
import com.ks.vo.ResStatus;
import com.ks.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author QiuQingyuan
 * @version 1.0
 * @Description: TODO
 * @date 2022-12-19  9:35
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public ResultVO insert(UserInfo userInfo){
        int i = userInfoMapper.insert(userInfo);
        if(i>0){
            return new ResultVO(ResStatus.OK,"success",null);
        }else{
            return new ResultVO(ResStatus.NO,"fail",null);
        }
    }

    @Override
    public ResultVO delete(Integer id) {
        int i = userInfoMapper.deleteById(id);
        if(i>0){
            return new ResultVO(ResStatus.OK,"success",null);
        }else{
            return new ResultVO(ResStatus.NO,"fail",null);
        }
    }

    @Override
    public ResultVO queryById(Integer id) {
        UserInfo userInfo = userInfoMapper.selectById(id);
        if(userInfo==null){
            return new ResultVO(ResStatus.NO,"fail",null);
        }else{
            return new ResultVO(ResStatus.OK,"success",userInfo);
        }
    }

    @Override
    public IPage<UserInfo> selectPage(Page<UserInfo> pageParam) {
        /*列表显示分页查询列表*/
        //1、排序：按照数据库中id字段排序
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");

        //2、分页查询
        return baseMapper.selectPage(pageParam,queryWrapper);
    }
}
