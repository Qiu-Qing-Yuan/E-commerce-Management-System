package com.ks.eshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionMenu implements Serializable {
   private Integer id;
   private Integer parentId;
   private FunctionMenu parentMenu;
   private String fcName;
   private String fcUrl;
   private char status;
   private Integer seq;
   private List<FunctionMenu> childMenu;
   private String createTime;
   private String updateTime;

   public FunctionMenu(Integer parentId, String fcName, String fcUrl) {
      this.parentId = parentId;
      this.fcName = fcName;
      this.fcUrl = fcUrl;
   }

   public FunctionMenu(Integer id, Integer parentId, String fcName, String fcUrl) {
      this.id = id;
      this.parentId = parentId;
      this.fcName = fcName;
      this.fcUrl = fcUrl;
   }
}
