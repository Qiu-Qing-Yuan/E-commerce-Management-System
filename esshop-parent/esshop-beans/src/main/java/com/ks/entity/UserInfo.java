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
public class UserInfo implements Serializable {

    private Integer id;
    private String userName;
    private String userPwd;
    private String realName;
    private String sex;
    private String email;
    private String address;
    private String status;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Date updateTime;
    private static final long serialVersionUID = 1L;

}
