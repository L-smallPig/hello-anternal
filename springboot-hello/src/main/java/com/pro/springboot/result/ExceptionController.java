package com.pro.springboot.result;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: ExceptionController
 * @description: 公共异常处理类
 * @author:liguangyue
 * @date: 2021/1/21 17:11
 **/
@RestControllerAdvice
public class ExceptionController {

    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    /**
     * 处理运行异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Result handleRuntimeException(HttpServletRequest request, RuntimeException ex) {
        LOGGER.error("错误信息打印：|{}", ex);
        LOGGER.error("请求地址：|{}" + request.getRequestURL());
        LOGGER.error("请求参数: |{}" + JSONUtil.toJsonStr(request.getParameterMap()));
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("requestUrl",request.getRequestURL());
        resultMap.put("exceptionMsg",ex.getMessage());
        resultMap.put("requestParams", JSONUtil.toJsonStr(request.getParameterMap()));
        resultMap.put("http_status_code",HttpStatus.BAD_REQUEST);
        return new Result(CommonError.ERROR.code(),CommonError.ERROR.msg(),resultMap);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception e){
        LOGGER.error("请求地址：|{}" + request.getRequestURL());
        LOGGER.error("请求参数: |{}" + JSONUtil.toJsonStr(request.getParameterMap()));
        //如果属于参数校验异常，就抛出校验的错误
        if (e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException methodArgumentNotValidException= (MethodArgumentNotValidException) e;
            return new Result(CommonError.ERROR.getCode(),CommonError.ERROR.getMsg(),
                    "校验错误："+methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
        }//如果是自定义的异常，就给出具体的异常原因
        else if (e instanceof MyException){
            return new Result(CommonError.ERROR.getCode(),CommonError.ERROR.getMsg(),"自定义的错误为："+e.getMessage());
        }
        //如果都不是就打印出异常的信息
        return new Result(CommonError.ERROR.getCode(),CommonError.ERROR.getMsg(),"错误的信息为："+e.getMessage());
    }
}
