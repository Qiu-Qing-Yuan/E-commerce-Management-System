package com.ks.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ks.entity.UserInfo;
import com.ks.vo.ResultVO;
import io.swagger.models.auth.In;

public interface UserInfoService extends IService<UserInfo> {

    public ResultVO insert(UserInfo userInfo);

    public ResultVO delete(Integer id);

    public ResultVO queryById(Integer id);

    IPage<UserInfo> selectPage(Page<UserInfo> pageParam);

}
