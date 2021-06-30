package com.pro.springboot.aspect;

import java.lang.annotation.*;

/**
 * @className: LogAnnotation
 * @description: 自定义注解
 * @author: liguangyue
 * @date: 2021/2/3 16:15
 **/
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

}
