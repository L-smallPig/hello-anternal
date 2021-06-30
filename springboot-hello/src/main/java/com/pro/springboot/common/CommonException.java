package com.pro.springboot.common;

import com.pro.springboot.result.CommonError;
import com.pro.springboot.result.Error;

public class CommonException extends RuntimeException implements Error {

    private String msg;
    private String code;

    public CommonException() {
        super();
    }

    /**
     * 只返回异常信息
     *
     * @param msg 异常信息
     */
    public CommonException(String msg) {
        this.setMsg(msg);
    }

    /**
     * 使用枚举类限制异常信息
     * @param commonError 异常封装枚举类
     * @param throwable 异常
     */
    public CommonException(CommonError commonError, Throwable throwable) {
        super(throwable);
        this.msg = commonError.getMsg();
        this.code = commonError.getCode();
    }

    /**
     * 返回异常信息和错误码
     *
     * @param code 错误码
     * @param msg 错误信息
     */
    public CommonException(String code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
    }

    /**
     * 返回信息和异常
     *
     * @param msg 异常信息
     * @param cause 异常
     */
    public CommonException(String msg, Throwable cause) {
        super(cause);
        this.setMsg(msg);
    }

    /**
     * 返回异常code 异常信息 和 异常
     *
     * @param code code
     * @param msg msg
     * @param cause cause
     */
    public CommonException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.setCode(code);
        this.setMsg(msg);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" \n" + "code:"+code + " \n");
        stringBuffer.append("msg:"+msg);
        return stringBuffer.toString();
    }
}
