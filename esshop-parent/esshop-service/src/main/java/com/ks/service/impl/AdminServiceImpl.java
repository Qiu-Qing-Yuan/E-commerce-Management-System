package com.ks.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.ks.dao.AdminInfoMapper;
import com.ks.entity.AdminInfo;
import com.ks.service.AdminInfoService;
import com.ks.utils.MD5Utils;
import com.ks.vo.ResStatus;
import com.ks.vo.ResultVO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

/**
 * @author QiuQingyuan
 * @version 1.0
 * @Description: TODO
 * @date 2022-12-18  10:19
 */
@Service
public class AdminServiceImpl implements AdminInfoService {

    @Autowired
    AdminInfoMapper adminInfoMapper;

    @Override
    public ResultVO queryByNameAndPwd(String adminName, String adminPwd) {
        QueryWrapper<AdminInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("admin_name",adminName)
                    .eq("status",'1');
        AdminInfo adminInfo = adminInfoMapper.selectOne(queryWrapper);
        if(adminInfo == null){
            return new ResultVO(ResStatus.NO,"登陆失败，该用户名不存在！",null);
        }else{
            String md5Pwd = MD5Utils.md5(adminPwd);
            if(md5Pwd.equals(adminInfo.getAdminPwd())){
                //如果要验证登录成功，则需要生成令牌token（token就是按照特定规则生成的字符串）
                //使用jwt规则生成token字符串
                JwtBuilder builder = Jwts.builder();
                HashMap<String, Object> map = new HashMap<>();
                map.put("key1","value1");
                map.put("key2","value2");

                String token = builder.setSubject(adminName) //主题就是token中携带的数据
                        .setIssuedAt(new Date()) //设置token的生成时间
                        .setId(adminInfo.getId() + "") //设置用户的id为token的id
                        .setClaims(map) //map中可以存放用户的角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))//设置token的过期时间
                        .signWith(SignatureAlgorithm.HS256, "yuan") //设置加密方式加密的密码
                        .compact();
                return new ResultVO(ResStatus.OK,token,adminInfo);
            }else{
                return new ResultVO(ResStatus.NO,"登录失败，密码错误！",null);
            }
        }
    }
}
