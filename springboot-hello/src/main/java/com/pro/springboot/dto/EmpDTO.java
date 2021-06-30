package com.pro.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: EmpDTO
 * @description: 员工DTO
 * @author: 李光跃
 * @date: 2020/12/16 17:06
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDTO {
    private String empId;
    private String empName;
    private int empAge;
    private String empGender;
    private String deptId;


    public static void main(String[] args) {
        String params = "openid=bsoft0001&timestamp=1615863068512&sign=Uf4ZiQz9uigSdTDDyx43mY30bLOz0f3a&idcard=2ZK1%2bkCEhvdZKsjhWJKBaQnYKRf6qOG6&sys_organ_code=320124001&sys_code=his&opeCode=LZziIYSQUbhfBHu4pEYs0g%3d%3d&opeName=Q1qNv9Ew2B8%2bb4UxfJXSCg%3d%3d&flag=1";
        List<String> paramList = Arrays.asList(params.split("&"));
        Map<String, String> paramMap = new HashMap<>();
        for (String str : paramList) {
            paramMap.put(str.split("=")[0],str.split("=")[1]);
        }
        System.out.println(paramMap);
    }
}
