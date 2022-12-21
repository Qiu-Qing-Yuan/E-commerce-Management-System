package com.ks.service.impl;

import com.ks.dao.ProductInfoMapper;
import com.ks.entity.ProductInfo;
import com.ks.service.ProductInfoService;
import com.ks.vo.ResStatus;
import com.ks.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author QiuQingyuan
 * @version 1.0
 * @Description: TODO
 * @date 2022-12-18  21:03
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public ResultVO insert(ProductInfo productInfo) {
        int i = productInfoMapper.insert(productInfo);
        if(i>0){
            return new ResultVO(ResStatus.OK,"success",null);
        }else {
            return new ResultVO(ResStatus.NO,"fail",null);
        }
    }
}
