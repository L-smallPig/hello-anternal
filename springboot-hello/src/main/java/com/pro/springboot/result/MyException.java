package com.pro.springboot.result;

/**
 * @className: MyException
 * @description: 公共异常处理类
 * @author: liguangyue
 * @date: 2021/1/21 17:13
 **/
public class MyException extends RuntimeException{

    /**
     * 错误信息
     */
    private String msg;

    public MyException(String msg) {
        super(msg);
    }
}
