package com.pro.springboot.result;

/**
 * @Description 公共返回类封装
 * @Author liguangyue
 * @Date 2020-09-23 17:04:06
 * @Copyright 2020-2025
 */
public class Result<T> {

    private String msg;
    private String code;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result()
    {

    }

    public Result(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public Result(String msg, String code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    /**
     * 成功返回
     *
     * @return Result
     */
    public static Result success()
    {
        Result result = new Result();
        result.setCode(CommonError.SUCCESS.code());
        result.setMsg(CommonError.SUCCESS.msg());
        return result;
    }

    /**
     * 成功返回
     *
     * @return Result
     */
    public static Result success(Object data)
    {
        Result result = new Result();
        result.setCode(CommonError.SUCCESS.code());
        result.setMsg(CommonError.SUCCESS.msg());
        result.setData(data);
        return result;
    }

    /**
     * 成功返回
     *
     * @param code 返回码
     * @param msg 返回信息
     * @return Result
     */
    public static Result success(String code, String msg)
    {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 成功返回
     *
     * @param code 返回码
     * @param msg 返回信息
     * @param data 返回结果
     * @return Result
     */
    public static Result success(String code, String msg, Object data)
    {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 失败返回
     *
     * @return Result
     */
    public static Result error()
    {
        Result result = new Result();
        result.setCode(CommonError.ERROR.code());
        result.setMsg(CommonError.ERROR.msg());
        return result;
    }

    /**
     * 失败返回
     *
     * @return Result
     */
    public static Result error(Object obj)
    {
        Result result = new Result();
        result.setCode(CommonError.ERROR.code());
        result.setMsg(CommonError.ERROR.msg());
        result.setData(obj);
        return result;
    }

    /**
     * 失败返回
     *
     * @param code 返回码
     * @param msg 返回信息
     * @return Result
     */
    public static Result error(String code, String msg)
    {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 失败返回
     *
     * @param code 返回码
     * @param msg 返回信息
     * @return Result
     */
    public static Result error(String code, String msg, Object obj)
    {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }

}
