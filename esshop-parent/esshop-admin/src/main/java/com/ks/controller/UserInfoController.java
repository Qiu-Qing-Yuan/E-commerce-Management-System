package com.ks.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ks.entity.UserInfo;
import com.ks.service.UserInfoService;
import com.ks.vo.ResStatus;
import com.ks.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author QiuQingyuan
 * @version 1.0
 * @Description: TODO
 * @date 2022-12-19  9:32
 */
@CrossOrigin
@RestController
@RequestMapping("/userInfo")
@Api(value = "客户信息管理",tags = "客户管理")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /*增加一条记录*/
    @PostMapping("/insert")
    public ResultVO insert(@RequestBody UserInfo userInfo,@RequestHeader("token")String token){
        return userInfoService.insert(userInfo);
    }

    /*根据id删除一条记录*/
    @DeleteMapping("delete/{id}")
    public ResultVO deleteById(@PathVariable Integer id){
        return userInfoService.delete(id);
    }

    /*根据id查询记录*/
    @GetMapping("/query/{id}")
    public ResultVO queryById(@PathVariable Integer id){
        return userInfoService.queryById(id);
    }

    /*查询所有记录*/
    @ApiOperation("客户分页列表")
    @GetMapping("/queryAll{page}/{limit}")
    public ResultVO selectPage(@ApiParam(value = "当前页码",required = true)@PathVariable Integer page,
                                     @ApiParam(value = "每页记录数",required = true)@PathVariable Integer limit){
        Page<UserInfo> pageParam = new Page<>(page,limit);
        IPage<UserInfo> pageModel = userInfoService.selectPage(pageParam);
        List<UserInfo> records = pageModel.getRecords();
        return new ResultVO(ResStatus.OK,"success",records);
    }





}
