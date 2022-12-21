package com.ks.eshop.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * (OrderInfo)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = -43171190935945843L;
    /**
     * 订单信息id
     */
    private Integer id;
    /**
     * 客户id
     */
    private Integer uid;
    private UserInfo userInfo;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单金额
     */
    private Double orderPrice;
    /**
     * 订单状态
     */
    private String status;
    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Date lateTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    //订单明细
    private ArrayList<OrderDetail> orderDetail;

    public OrderInfo(Integer uid, String orderCode, String status, Date createTime, Date lateTime) {
        this.uid = uid;
        this.orderCode = orderCode;
        this.status = status;
        this.createTime = createTime;
        this.lateTime = lateTime;
    }
}
