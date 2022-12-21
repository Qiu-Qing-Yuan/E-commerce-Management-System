package com.ks.eshop.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableData<T> implements Serializable {
    private Integer total;//总记录数
    private T rows;//查询到的数据
}
