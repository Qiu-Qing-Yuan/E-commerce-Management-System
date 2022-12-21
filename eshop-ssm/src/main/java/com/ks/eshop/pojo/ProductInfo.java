package com.ks.eshop.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo implements Serializable {
   private Integer id;
   @NotBlank(message = "商品编号不能为空")
   @Length(max = 20, message = "商品编号长度不能大于20")
   private String pdCode;
   @NotBlank(message = "商品名称不能为空")
   private String pdName;
   @NotNull(message = "商品类型不能为空")
   private Integer tid;
   @NotBlank(message = "商品品牌不能为空")
   private String brand;
   private String image;
   @NotBlank(message = "商品价格不能为空")
   private String price;
   private String hPrice;
   @NotNull(message = "商品数量不能为空")
   private Integer num;
   @Length(max = 200, message = "商品描述长度不能大于200")
   private String remark;
   private char status;
   private ProductType type;
   @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //出参
   private Date createTime;
   private Date updateTime;

   public ProductInfo(String pdCode, String pdName, Integer tid, String brand, String price, String hPrice) {
      this.pdCode = pdCode;
      this.pdName = pdName;
      this.tid = tid;
      this.brand = brand;
      this.price = price;
      this.hPrice = hPrice;
   }
}
