package com.ks.controller;

import com.ks.service.AdminInfoService;
import com.ks.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author QiuQingyuan
 * @version 1.0
 * @Description: TODO
 * @date 2022-12-18  9:44
 */
@CrossOrigin
@RestController
@RequestMapping("/adminInfo")
@Api(value = "提供管理员信息管理",tags = "管理员管理")
public class AdminInfoController {

    @Autowired
    AdminInfoService adminInfoService;

    @ApiOperation("管理员登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "adminName", value = "管理员登录账号", required = true),
            @ApiImplicitParam(dataType = "string", name = "adminPwd", value = "管理员登录密码", required = true)
    })
    @GetMapping("/queryAdmin")
    public ResultVO queryAdmin(@RequestParam("adminName") String adminName,
                               @RequestParam("adminPwd") String adminPwd){
       return adminInfoService.queryByNameAndPwd(adminName,adminPwd);
    }



}
