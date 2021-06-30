package com.pro.springboot.result;

public enum CommonError implements Error {
    SUCCESS("000000","SUCCESS"),
    ERROR("999999","ERROR"),
    FORBIDDEN("888888", "权限不足"),
    A_0000001("0000001","鉴权失败"),
    /**
     * 0=停止
     */
    STOP("0", "停止"),
    /**
     * 1=运行
     */
    RUNNING("1", "运行");


    private String code;
    private String msg;

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

    CommonError() {
    }

    CommonError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }

}
