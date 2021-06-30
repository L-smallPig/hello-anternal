package com.pro.springboot.chenktoken;

import com.alibaba.fastjson.JSON;
import com.pro.springboot.result.CommonError;
import com.pro.springboot.result.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @className: MyAuthenticationSuccessHandler
 * @description: 认证成功处理类
 * @author: liguangyue
 * @date: 2021/2/2 9:29
 **/
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        //生成token
        final String realToken = jwtTokenUtil.generateToken(authentication.getName());
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", realToken);
        Result result = new Result();
        result.setCode(CommonError.SUCCESS.code());
        result.setMsg(CommonError.SUCCESS.msg());
        result.setData(realToken);

        //将生成的authentication放入容器中，生成安全的上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String json = JSON.toJSONString(result);
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(json);
    }
}
