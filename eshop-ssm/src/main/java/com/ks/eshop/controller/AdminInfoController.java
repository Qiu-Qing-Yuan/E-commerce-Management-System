package com.ks.eshop.controller;

import com.ks.eshop.common.Result;
import com.ks.eshop.common.TableData;
import com.ks.eshop.pojo.AdminInfo;
import com.ks.eshop.pojo.Permission;
import com.ks.eshop.service.AdminInfoService;
import com.ks.eshop.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/adminInfo")
public class AdminInfoController {
    @Autowired
    private AdminInfoService adminInfoService;

    @Autowired
    private PermissionService permissionService;

    //增加一条记录
    @PostMapping("/insert")
    public Result insert(@RequestBody AdminInfo adminInfo) {
        AdminInfo adminInfo1 = adminInfoService.insert(adminInfo);
        System.out.println(adminInfo1);
        ArrayList<Permission> permissions = adminInfo.getPermissions();
        for (Permission permission : permissions) {
            permission.setAid(adminInfo1.getId());
        }
        System.out.println(permissions);
        int i = permissionService.insertBatch(permissions);
        if (i>0) return Result.success();
        return Result.fail();
    }

    //根据id删除记录
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        int i = adminInfoService.deleteById(id);
        if (i>0) return Result.success();
        return Result.fail();
    }

    //根据id查询记录
    @GetMapping("/query/{id}")
    public Result queryById(@PathVariable Integer id) {
        AdminInfo adminInfo = adminInfoService.queryById(id);
        if (adminInfo!=null) return Result.success(adminInfo);
        return Result.fail();
    }

    //查询所有记录
    @GetMapping("/queryAll")
    public TableData queryAll() {
        List<AdminInfo> adminInfos = adminInfoService.queryAll();
        if (adminInfos!=null&&adminInfos.size()>0){
            return new TableData(adminInfos.size(),adminInfos);
        }
        return null;
    }

    //根据id修改记录
    @PutMapping("/update")
    public Result update(@RequestBody AdminInfo adminInfo) {
        int i = adminInfoService.updateById(adminInfo);
        //将该管理员的权限删除，再重新插入新的权限
        int i1 = permissionService.deleteByAid(adminInfo.getId());
        ArrayList<Permission> permissions = adminInfo.getPermissions();
        for (Permission permission : permissions) {
            permission.setAid(adminInfo.getId());
        }
        int i2 = permissionService.insertBatch(permissions);
        if (i>0 && i1>0 && i2>0) return Result.success();
        return Result.fail();
    }

    //根据id修改status
    @PutMapping("/updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable("id")Integer id,@PathVariable("status")char status){
        int i = adminInfoService.updateStatus(id, status);
        if (i>0) return Result.success();
        return Result.fail();
    }

    //管理员登录
    @PostMapping("/queryAdmin")
    public Result queryAdmin(@RequestBody AdminInfo adminInfo, HttpSession session)  {
        AdminInfo adminInfo1 = adminInfoService.queryByNameAndPwd(adminInfo.getAdminName(), adminInfo.getAdminPwd());
        if (adminInfo1!=null){
            session.setAttribute("admin",adminInfo1.getAdminName());
            session.setAttribute("admin_id",adminInfo1.getId());
            return Result.success();
        }
        return Result.fail();
    }
}
