package com.ks.eshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Permission)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission implements Serializable {
    private static final long serialVersionUID = -60588747861558301L;
    /**
     * 权限id
     */
    private Integer id;
    /**
     * 管理员id
     */
    private Integer aid;
    /**
     * 菜单id
     */
    private Integer fid;

}
