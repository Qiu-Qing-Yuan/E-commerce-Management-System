package com.ks.service;

import com.ks.entity.ProductInfo;
import com.ks.vo.ResultVO;

public interface ProductInfoService {

    //增加一条记录
    ResultVO insert(ProductInfo productInfo);
}
