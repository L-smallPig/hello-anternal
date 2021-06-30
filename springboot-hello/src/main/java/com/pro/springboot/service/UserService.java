package com.pro.springboot.service;

import com.pro.springboot.dto.RegisterDTO;
import com.pro.springboot.chenktoken.User;

/**
 * @className: UserService
 * @description: 用户服务
 * @author: liguangyue
 * @date: 2021/1/21 17:27
 **/
public interface UserService {

    String registerUser(RegisterDTO registerDTO);

    /**
    *
    * @description: 查询用户详情
    * @author: liguangyue
    * @param: token
    * @return: User
    * @date: 2021/1/25 10:51
    **/
    User getUserInfo(String token);

    void save(User user);

    String returnMsg();
}
