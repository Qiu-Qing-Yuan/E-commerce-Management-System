package com.ks.eshop.service;

import com.ks.eshop.pojo.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OrderDetail)表服务接口
 */
public interface OrderDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderDetail queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<OrderDetail> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param orderDetail 实例对象
     * @return 实例对象
     */
    OrderDetail insert(OrderDetail orderDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrderDetail> entities);

    /**
     * 修改数据
     *
     * @param orderDetail 实例对象
     * @return 实例对象
     */
    OrderDetail update(OrderDetail orderDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    //根据订单id查询记录
    List<OrderDetail> queryByOid(@Param("oid") Integer oid);

}
