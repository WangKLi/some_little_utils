package com.open.little.base;

/**
 * Created by ace on 2017/8/23.
 */
public class BaseResponse {
    private int status = 20000;
    private String msg = "操作成功";

    public BaseResponse(int status, String message) {
        this.status = status;
        this.msg = message;
    }

    public BaseResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
