package com.ks.eshop.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductType implements Serializable {
   private Integer id;
   private String typeName;
   @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
   private Date createTime;
   private Date updateTime;

   public ProductType(String typeName) {
      this.typeName = typeName;
   }

   public ProductType(Integer id, String typeName) {
      this.id = id;
      this.typeName = typeName;
   }
}
