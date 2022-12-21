package com.ks.eshop.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeData implements Serializable {
    private Integer id;
    private String title;
    private List<TreeData> children;
    private Boolean spread;
}
