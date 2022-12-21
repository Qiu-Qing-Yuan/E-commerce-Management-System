package com.ks.eshop.service.impl;

import com.ks.eshop.pojo.OrderInfo;
import com.ks.eshop.dao.OrderInfoDao;
import com.ks.eshop.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * (OrderInfo)表服务实现类
 */
@Service("orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoDao orderInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderInfo queryById(Integer id) {
        return this.orderInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<OrderInfo> queryAllByLimit(int offset, int limit) {
        return this.orderInfoDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<OrderInfo> queryAll(OrderInfo orderInfo) {
        return orderInfoDao.queryAll(orderInfo);
    }

    /**
     * 新增数据
     *
     * @param orderInfo 实例对象
     * @return 实例对象
     */
    @Override
    public OrderInfo insert(OrderInfo orderInfo) {
        this.orderInfoDao.insert(orderInfo);
        return orderInfo;
    }

    /**
     * 修改数据
     *
     * @param orderInfo 实例对象
     * @return 实例对象
     */
    @Override
    public OrderInfo update(OrderInfo orderInfo) {
        this.orderInfoDao.update(orderInfo);
        return this.queryById(orderInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderInfoDao.deleteById(id) > 0;
    }

    @Override
    public int queryCounts() {
        return orderInfoDao.queryCounts();
    }
}
