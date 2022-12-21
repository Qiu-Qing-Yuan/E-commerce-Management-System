package com.ks.eshop.controller;

import com.ks.eshop.common.Page;
import com.ks.eshop.common.Result;
import com.ks.eshop.common.TableData;
import com.ks.eshop.pojo.UserInfo;
import com.ks.eshop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    //增加一条记录
    @PostMapping("/insert")
    public Boolean insert(@RequestBody UserInfo userInfo) {
        int i = userInfoService.insert(userInfo);
        return i > 0;
    }

    //根据id删除记录
    @DeleteMapping("/delete/{id}")
    public Boolean deleteById(@PathVariable Integer id) {
        int i = userInfoService.deleteById(id);
        return i > 0;
    }

    //根据id查询记录
    @GetMapping("/query/{id}")
    public UserInfo queryById(@PathVariable Integer id) {
        return userInfoService.queryById(id);
    }

    //查询所有记录
    @GetMapping("/queryAlls")
    public Result queryAlls(){
        List<UserInfo> userInfos = userInfoService.queryAlls();
        if (userInfos!=null&& userInfos.size()>0){
            return Result.success(userInfos);
        }
        return Result.fail();
    }

    //分页查询所有记录
    @GetMapping("/queryAll")
    public TableData queryAll(@RequestParam("pageNumber")Integer pageNumber,
                                   @RequestParam("pageSize")Integer pageSize,
                              @RequestParam("username")String username) {
        if (!username.isEmpty()){
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(username);
            List<UserInfo> userInfos = userInfoService.query(userInfo);
            return new TableData(userInfos.size(),userInfos);
        }else {
            int total = userInfoService.queryCounts();//求出总记录数
            Page page = new Page(pageNumber, pageSize);//当前页数 。 每一页多少数据
            List<UserInfo> userInfos = userInfoService.queryAll(page.getStartIoc(),page.getPageSize());
            if (userInfos!=null&&userInfos.size()>0){
                return new TableData(total,userInfos);
            }
        }
        return null;
    }

    //根据id修改用户状态
    @PutMapping("/updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable("id")Integer id,@PathVariable("status")char status){
        int i = userInfoService.updateStatusById(id, status);
        if (i>0) return Result.success();
        return Result.fail();
    }

    //根据id修改记录
    @PutMapping("/update")
    public Boolean update(@RequestBody UserInfo userInfo) {
        int i = userInfoService.updateById(userInfo);
        return i > 0;
    }
}
