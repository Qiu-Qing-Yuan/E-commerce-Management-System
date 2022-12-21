package com.ks.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo  implements Serializable {

    private Integer id;
    private String pdCode;
    private String pdName;
    private Integer tid;
    private String brand;
    private String image;
    private String price;
    private Integer num;
    private String remark;
    private char status;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //出参
    private Date createTime;
    private Date updateTime;

}
