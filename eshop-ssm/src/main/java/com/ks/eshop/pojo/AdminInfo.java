package com.ks.eshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInfo implements Serializable {
   private Integer id;
   private String adminName;
   private String adminPwd;
   private char status;
   private ArrayList<Permission> permissions;
   private String createTime;
   private String updateTime;

   public AdminInfo(Integer id, String adminName, String adminPwd) {
      this.id = id;
      this.adminName = adminName;
      this.adminPwd = adminPwd;
   }

   public AdminInfo(String adminName, String adminPwd) {
      this.adminName = adminName;
      this.adminPwd = adminPwd;
   }
}
