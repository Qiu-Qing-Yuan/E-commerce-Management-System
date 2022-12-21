package com.ks.eshop.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public Result(ResultCode resultCode, T data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
    public Result(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public static <T>Result success(T data){
        return new Result(ResultCode.SUCCESS,data);
    }
    public static <T>Result success(){
        return new Result(ResultCode.SUCCESS);
    }

    public static <T>Result fail(T data){
        return new Result(ResultCode.FAIL,data);
    }

    public static <T>Result fail(){
        return new Result(ResultCode.FAIL);
    }
}
