package com.ks.eshop.controller;

import com.ks.eshop.common.Result;
import com.ks.eshop.common.TableData;
import com.ks.eshop.pojo.ProductInfo;
import com.ks.eshop.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {
    @Autowired
    private ProductInfoService productInfoService;

    //增加一条记录
    @PostMapping("/insert")
    public Result insert(@RequestBody @Valid ProductInfo productInfo, BindingResult result) {
        HashMap<String, String> errorMap = new HashMap<>();
        if (result.hasErrors()){
            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(),error.getDefaultMessage());
            }
            return Result.fail(errorMap);
        }else {
            int i = productInfoService.insert(productInfo);
            if (i>0) return Result.success();
            else return Result.fail();
        }
    }

    //根据id删除记录
    @DeleteMapping("/delete/{id}")
    public Boolean deleteById(@PathVariable Integer id) {
        int i = productInfoService.deleteById(id);
        return i > 0;
    }

    //根据id查询记录
    @GetMapping("/query/{id}")
    public Result queryById(@PathVariable Integer id) {
        ProductInfo productInfo = productInfoService.queryById(id);
        if (productInfo!=null){
            return Result.success(productInfo);
        }
        return Result.fail();
    }

    //查询所有记录
    @GetMapping("/queryAlls")
    public Result queryAlls(){
        List<ProductInfo> productInfos = productInfoService.queryAll();
        if (productInfos!=null&&productInfos.size()>0){
            return Result.success(productInfos);
        }
        return null;
    }

    //按条件查询记录
    @PostMapping("/queryByCondition")
    public Result queryByCondition(@RequestBody ProductInfo productInfo) {
        List<ProductInfo> productInfos = productInfoService.queryByCondition(productInfo);
        if (productInfo!=null&&productInfos.size()>0){
            return Result.success(productInfos);
        }
        else return Result.fail();
    }

    //查询所有记录bootstrap_table
    @GetMapping("/queryAll")
    public TableData queryByPage(@RequestParam("pageNumber")Integer pageNumber,
                               @RequestParam("pageSize")Integer pageSize,
                                 @RequestParam("code")String code,
                                 @RequestParam("name")String name,
                                 @RequestParam("brand")String brand,
                                 @RequestParam("type")String type,
                                 @RequestParam("low_p")String lowP,
                                 @RequestParam("high_p")String highP) {
        //条件搜索
        if (code.isEmpty() && name.isEmpty() && brand.isEmpty() && type.equals("0") && lowP.isEmpty() && highP.isEmpty()){
            //获取总记录数
            int total = productInfoService.queryCounts();
            //每一页的第一条记录开始编号
            int start = (pageNumber-1)*pageSize;
            List<ProductInfo> productInfos = productInfoService.queryByPage(start,pageSize);
            return new TableData(total, productInfos);
        }else {
            ProductInfo productInfo = new ProductInfo(code, name, Integer.valueOf(type), brand, lowP, highP);
            List<ProductInfo> productList = productInfoService.queryByCondition(productInfo);
            return new TableData(productList.size(), productList);
        }
    }

    //根据id修改记录
    @PutMapping("/update")
    public Result update(@RequestBody @Valid ProductInfo productInfo, BindingResult result) {
        HashMap<String, String> errorMap = new HashMap<>();
        if (result.hasErrors()){
            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(),error.getDefaultMessage());
            }
            return Result.fail(errorMap);
        }else {
            int i = productInfoService.updateById(productInfo);
            if (i>0) return Result.success();
            else return Result.fail();
        }
    }
}
