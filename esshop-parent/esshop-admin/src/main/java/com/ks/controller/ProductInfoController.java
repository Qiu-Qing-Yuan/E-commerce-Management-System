package com.ks.controller;

import com.ks.entity.ProductInfo;
import com.ks.service.ProductInfoService;
import com.ks.vo.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author QiuQingyuan
 * @version 1.0
 * @Description: TODO
 * @date 2022-12-18  21:01
 */
@CrossOrigin
@RestController
@RequestMapping("/productInfo")
@Api(value = "提供商品信息管理",tags = "商品管理")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @PostMapping("/insert")
    public ResultVO insert(@RequestBody ProductInfo productInfo,@RequestHeader("token")String token){
        return productInfoService.insert(productInfo);
    }
}
