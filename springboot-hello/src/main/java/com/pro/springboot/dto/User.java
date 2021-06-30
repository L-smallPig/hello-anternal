package com.pro.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: User
 * @description: 用户DTO
 * @author: liguangyue
 * @date: 2020/12/21 17:46
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String fname;
    private String phone;
    private String email;
    private String password;
    private String name;
    private String idcard;
    private String headimg;
    private String introduce;
    private String rtime;

}
