package com.ks.eshop.service.impl;

import com.ks.eshop.pojo.OrderDetail;
import com.ks.eshop.dao.OrderDetailDao;
import com.ks.eshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * (OrderDetail)表服务实现类
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderDetail queryById(Integer id) {
        return this.orderDetailDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<OrderDetail> queryAllByLimit(int offset, int limit) {
        return this.orderDetailDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orderDetail 实例对象
     * @return 实例对象
     */
    @Override
    public OrderDetail insert(OrderDetail orderDetail) {
        this.orderDetailDao.insert(orderDetail);
        return orderDetail;
    }

    @Override
    public int insertBatch(List<OrderDetail> entities) {
        return orderDetailDao.insertBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param orderDetail 实例对象
     * @return 实例对象
     */
    @Override
    public OrderDetail update(OrderDetail orderDetail) {
        this.orderDetailDao.update(orderDetail);
        return this.queryById(orderDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderDetailDao.deleteById(id) > 0;
    }

    @Override
    public List<OrderDetail> queryByOid(Integer oid) {
        return orderDetailDao.queryByOid(oid);
    }
}
