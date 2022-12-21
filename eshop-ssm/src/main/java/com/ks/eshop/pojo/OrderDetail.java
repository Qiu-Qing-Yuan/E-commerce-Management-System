package com.ks.eshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (OrderDetail)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 299557973259041058L;
    /**
     * 订单明细id
     */
    private Integer id;
    /**
     * 订单信息id
     */
    private Integer oid;
    private OrderInfo orderInfo;
    /**
     * 商品信息id
     */
    private Integer pid;
    private ProductInfo productInfo;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
