package com.yugao.controller;

public class Result {

    private boolean isSuccess = true;
    private Object data = null;
    private Integer errCode;
    private String msg;

    public Result() {
    }

    public Result(String msg) {
        this.msg = msg;
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(Integer errCode) {
        this.isSuccess = false;
        this.errCode = errCode;
    }

    public Result(Object data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public Result(Integer errCode, String msg) {
        this.isSuccess = false;
        this.errCode = errCode;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }
}
