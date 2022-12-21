package com.ks.eshop.service.impl;

import com.ks.eshop.dao.ProductInfoDao;
import com.ks.eshop.pojo.ProductInfo;
import com.ks.eshop.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public int insert(ProductInfo product_info) {
        return productInfoDao.insert(product_info);
    }

    @Override
    public int deleteById(int id) {
        return productInfoDao.deleteById(id);
    }

    @Override
    public ProductInfo queryById(int id) {
        return productInfoDao.queryById(id);
    }

    @Override
    public List<ProductInfo> queryAll() {
        return productInfoDao.queryAll();
    }

    @Override
    public int updateById(ProductInfo product_info) {
        return productInfoDao.updateById(product_info);
    }

    @Override
    public List<ProductInfo> queryByPage(int offset, int size) {
        return productInfoDao.queryByPage(offset,size);
    }

    @Override
    public int queryCounts() {
        return productInfoDao.queryCounts();
    }

    @Override
    public List<ProductInfo> queryByCondition(ProductInfo productInfo) {
        return productInfoDao.queryByCondition(productInfo);
    }
}
