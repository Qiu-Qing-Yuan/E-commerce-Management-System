package com.ks.eshop.controller;

import com.ks.eshop.common.Result;
import com.ks.eshop.common.TableData;
import com.ks.eshop.common.TreeData;
import com.ks.eshop.pojo.FunctionMenu;
import com.ks.eshop.service.FunctionMenuService;
import com.ks.eshop.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/functionMenu")
public class FunctionMenuController {
    @Autowired
    private FunctionMenuService functionMenuService;

    @Autowired
    private PermissionService permissionService;

    //增加一条记录
    @PostMapping("/insert")
    public Result insert(@RequestBody FunctionMenu functionMenu) {
        int i = functionMenuService.insert(functionMenu);
        if (i>0) return Result.success();
        return Result.fail();
    }

    //根据id删除记录
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        int i = functionMenuService.deleteById(id);
        if (i>0) return Result.success();
        return Result.fail();
    }

    //根据id查询记录
    @GetMapping("/query/{id}")
    public Result queryById(@PathVariable Integer id) {
        FunctionMenu functionMenu = functionMenuService.queryById(id);
        if (functionMenu!=null) return Result.success(functionMenu);
        return Result.fail();
    }

    //查询所有记录
    @GetMapping("/queryAll")
    public Result queryAll(HttpServletRequest request) {
//        List<FunctionMenu> functionMenus = functionMenuService.queryAll();
        int admin_id = (Integer) request.getSession().getAttribute("admin_id");
        List<FunctionMenu> functionMenus = permissionService.queryByAidForMenu(admin_id);
        if (functionMenus!=null&&functionMenus.size()>0){
            return Result.success(functionMenus);
        }
        return Result.fail();
    }

    //查询所有记录
    @GetMapping("/queryAlls")
    public TableData queryAlls() {
        List<FunctionMenu> functionMenus = functionMenuService.queryAlls();
        return new TableData(functionMenus.size(), functionMenus);
    }

    //查询所有记录,返回TreeData数据格式
    @GetMapping("/queryAllForTree")
    public Result queryAllForTree() {
        ArrayList<TreeData> treeData = new ArrayList<>();
        List<FunctionMenu> menus = functionMenuService.queryAll();
        ArrayList<TreeData> data = getChild(menus, treeData);
        if (data!=null&&data.size()>0) return Result.success(data);
        return Result.fail();
    }
    private ArrayList<TreeData> getChild(List<FunctionMenu> functionMenus,ArrayList<TreeData> treeData){
        if (functionMenus!=null){
            for (FunctionMenu menu : functionMenus) {
                TreeData tree = new TreeData();
                tree.setId(menu.getId());
                tree.setTitle(menu.getFcName());
                tree.setSpread(true);
                ArrayList<TreeData> treeData2 = new ArrayList<>();
                List<FunctionMenu> childMenu = menu.getChildMenu();
                tree.setChildren(getChild(childMenu,treeData2));
                treeData.add(tree);
            }
        }
        return treeData;
    }

    //根据id修改记录
    @PutMapping("/update")
    public Result update(@RequestBody FunctionMenu functionMenu) {

        int i = functionMenuService.updateById(functionMenu);
        if (i>0) return Result.success();
        return Result.fail();
    }

    //根据id修改status
    @PutMapping("/updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable("id")Integer id,@PathVariable("status")char status){
        System.out.println(id);
        System.out.println(status);
        int i = functionMenuService.updateStatusById(id, status);
        if (i>0) return Result.success();
        return Result.fail();
    }

//    @GetMapping("/queryByAidForMenu")
//    public Result queryByAidForMenu(){
//        List<FunctionMenu> functionMenus = permissionService.queryByAidForMenu(3);
//        return Result.success(functionMenus);
//    }
}
