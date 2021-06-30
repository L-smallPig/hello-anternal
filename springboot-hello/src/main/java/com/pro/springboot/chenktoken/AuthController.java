package com.pro.springboot.chenktoken;

import com.pro.springboot.aspect.LogAnnotation;
import com.pro.springboot.result.Result;
import com.pro.springboot.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: AuthController
 * @description: 注册Controller类
 * @author: liguangyue
 * @date: 2021/1/25 11:23
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private UserService userService;

//    @Resource
//    private WebSecurityConfig webSecurityConfig;

    @LogAnnotation
    @RequestMapping("/get")
    public Result get(){
        HashMap map = new HashMap();
        map.put("username","admin");
        map.put("password","123456");
        return Result.success(map);
    }

    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping("/del")
    public String del(){

        return "删除成功";
    }

    @PostMapping("/register")
    public Result registerUser(@RequestBody Map<String,String> registerUser){
        User user = new User();
        user.setUserName(registerUser.get("username"));
//        user.setPassword(webSecurityConfig.passwordEncoder().encode(registerUser.get("password")));
        user.setRole("ROLE_USER");
        userService.save(user);
        return Result.success();
    }
}
