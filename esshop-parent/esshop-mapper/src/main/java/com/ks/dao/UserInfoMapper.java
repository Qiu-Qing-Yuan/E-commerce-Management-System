package com.ks.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ks.entity.AdminInfo;
import com.ks.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
