package com.ks.eshop.controller;

import com.ks.eshop.common.Result;
import com.ks.eshop.common.TableData;
import com.ks.eshop.pojo.ProductType;
import com.ks.eshop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productType")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    //增加一条记录
    @PostMapping("/insert/{typeName}")
    public Result insert(@PathVariable("typeName") String typeName) {
        ProductType productType = productTypeService.queryByTypeName(typeName);
        if (productType==null){
            int i = productTypeService.insert(new ProductType(typeName));
            if (i>0) return Result.success();
            else return Result.fail();
        }else {
            return Result.fail();
        }
    }

    //根据id删除记录
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        int i = productTypeService.deleteById(id);
        if (i>0){
            return Result.success();
        }
        return Result.fail();
    }

    //根据id查询记录
    @GetMapping("/query/{id}")
    public Result queryById(@PathVariable Integer id) {
        ProductType productType = productTypeService.queryById(id);
        if (productType!=null){
            return Result.success(productType);
        }
        return Result.fail();
    }

    //查询所有记录table
    @GetMapping("/queryAlls")
    public TableData queryAlls() {
        List<ProductType> productTypes = productTypeService.queryAll();
        if (productTypes!=null&&productTypes.size()>0){
            return new TableData(productTypes.size(),productTypes);
        }
        return null;
    }

    //查询所有记录
    @GetMapping("/queryAll")
    public List<ProductType> queryAll() {
        List<ProductType> productTypes = productTypeService.queryAll();
        return productTypes;
    }



    //根据id修改记录
    @PutMapping("/update/{id}/{typeName}")
    public Result update(@PathVariable("id") Integer id,@PathVariable("typeName") String typeName) {
        ProductType productType = productTypeService.queryByTypeName(typeName);
        if (productType==null){
            int i = productTypeService.updateById(new ProductType(id,typeName));
            if (i>0) return Result.success();
            else return Result.fail();
        }else {
            return Result.fail();
        }
    }
}
