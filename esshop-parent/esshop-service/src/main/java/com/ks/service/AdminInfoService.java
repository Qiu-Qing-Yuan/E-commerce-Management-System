package com.ks.service;

import com.ks.entity.AdminInfo;
import com.ks.vo.ResultVO;

public interface AdminInfoService {

    /*根据登录名和密码查询用户*/
    ResultVO queryByNameAndPwd(String adminName, String adminPwd);
}
