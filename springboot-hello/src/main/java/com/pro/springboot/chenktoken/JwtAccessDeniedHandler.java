package com.pro.springboot.chenktoken;

import com.alibaba.fastjson.JSON;
import com.pro.springboot.result.CommonError;
import com.pro.springboot.result.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: JwtAccessDeniedHandler
 * @description: 权限不足处理
 * @author: liguangyue
 * @date: 2021/2/2 9:20
 **/
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        Result result = new Result();
        result.setCode(CommonError.FORBIDDEN.code());
        result.setMsg(CommonError.FORBIDDEN.msg());
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
