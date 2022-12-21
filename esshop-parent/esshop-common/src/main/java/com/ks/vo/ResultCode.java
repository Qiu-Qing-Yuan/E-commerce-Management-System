package com.ks.vo;

/**
 * @author QiuQingyuan
 * @version 1.0
 * @Description: TODO
 * @date 2022-12-18  9:41
 */
public enum ResultCode {

    SUCCESS("1","操作成功"),
    FAIL("0","操作失败");

    private String code;
    private String msg;

    ResultCode(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
