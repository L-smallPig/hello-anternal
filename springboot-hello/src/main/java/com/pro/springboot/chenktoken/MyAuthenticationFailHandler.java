package com.pro.springboot.chenktoken;

import com.alibaba.fastjson.JSON;
import com.pro.springboot.result.CommonError;
import com.pro.springboot.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring security登录失败处理类
 *  * GYB
 *  * 20190220
 */
@Component
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {

    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MyAuthenticationFailHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        LOGGER.info("=====登录失败=====");
        Result result  = new Result();
        result.setCode(CommonError.ERROR.code());
        result.setMsg(CommonError.ERROR.msg());
        result.setCode("登录失败");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
        httpServletResponse.getWriter().flush();
    }
}
