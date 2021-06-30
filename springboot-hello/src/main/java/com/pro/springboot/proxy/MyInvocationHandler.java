//package com.pro.springboot.proxy;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//
///**
// * @className: MyInvocationHandler
// * @description: 动态代理
// * @author: liguangyue
// * @date: 2021/1/22 9:50
// **/
//public class MyInvocationHandler implements InvocationHandler {
//
//    /**
//     * 日志对象
//     */
//    private static final Logger LOGGER = LoggerFactory.getLogger(MyInvocationHandler.class);
//
//    private Object object;
//    public MyInvocationHandler(Object object){
//        this.object = object;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        LOGGER.info(method.getName() + "方法调用前");
//        method.invoke(object, args);
//        LOGGER.info(method.getName() + "方法调用后");
//        return null;
//    }
//}
