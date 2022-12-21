package com.ks.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ks.entity.AdminInfo;
import com.ks.entity.OrderInfo;
import com.ks.entity.OrderInfoKey;

public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    int deleteByPrimaryKey(OrderInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    int insert(OrderInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    int insertSelective(OrderInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    OrderInfo selectByPrimaryKey(OrderInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    int updateByPrimaryKeySelective(OrderInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Dec 18 09:32:51 CST 2022
     */
    int updateByPrimaryKey(OrderInfo record);
}