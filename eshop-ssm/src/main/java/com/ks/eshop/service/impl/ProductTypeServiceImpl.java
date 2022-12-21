package com.ks.eshop.service.impl;

import com.ks.eshop.dao.ProductTypeDao;
import com.ks.eshop.pojo.ProductType;
import com.ks.eshop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    public int insert(ProductType product_type) {
        return productTypeDao.insert(product_type);
    }

    @Override
    public int deleteById(int id) {
        return productTypeDao.deleteById(id);
    }

    @Override
    public ProductType queryById(int id) {
        return productTypeDao.queryById(id);
    }

    @Override
    public List<ProductType> queryAll() {
        return productTypeDao.queryAll();
    }

    @Override
    public int updateById(ProductType product_type) {
        return productTypeDao.updateById(product_type);
    }

    @Override
    public ProductType queryByTypeName(String typeName) {
        return productTypeDao.queryByTypeName(typeName);
    }
}
