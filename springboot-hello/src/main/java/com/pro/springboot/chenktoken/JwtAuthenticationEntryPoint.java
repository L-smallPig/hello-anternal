package com.pro.springboot.chenktoken;

import com.alibaba.fastjson.JSON;
import com.pro.springboot.result.CommonError;
import com.pro.springboot.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: JwtAuthenticationEntryPoint
 * @description:
 * @author: liguangyue
 * @date: 2021/1/25 11:18
 **/
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request,HttpServletResponse response,AuthenticationException authException) throws IOException {
        LOGGER.info("=====认证失败=====");
        Result result = new Result();
        result.setCode(CommonError.FORBIDDEN.code());
        result.setMsg(CommonError.FORBIDDEN.msg());
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
        /**
         * 当用户尝试访问安全的REST资源而不提供任何凭据时，将调用此方法发送401 响应
         */
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException == null ? "Unauthorized":authException.getMessage());
    }
}
