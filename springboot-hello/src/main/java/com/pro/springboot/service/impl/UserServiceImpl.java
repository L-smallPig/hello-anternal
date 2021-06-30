package com.pro.springboot.service.impl;

import com.pro.springboot.chenktoken.User;
import com.pro.springboot.dto.RegisterDTO;
import com.pro.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @className: UserServiceImpl
 * @description: 用户服务实现类
 * @author: liguangyue
 * @date: 2021/1/21 17:28
 **/
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String registerUser(RegisterDTO registerDTO) {

        return "admin";
    }

    @Override
    public User getUserInfo(String token) {
        return null;
    }

    @Override
    public void save(User user) {
       user.setId("1");
    }

    @Override
    public String returnMsg() {
        return "test";
    }
}
