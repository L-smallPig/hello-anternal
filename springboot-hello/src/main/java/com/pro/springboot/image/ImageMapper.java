package com.pro.springboot.image;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName ImageMapper
 * @Description 获取头像
 * @Author liguangyue
 * @Date 2021/4/14 9:17
 * @Version 1.0
 **/
@Mapper
public interface ImageMapper {

    /**
    *
    * @description: 根据身份证号获取头像图片
    * @author: liguangyue
    * @param: idCard 身份证号
    * @return: String
    * @date: 2021/4/14 9:18
    **/
    ImageDTO getImageByIdCard(@Param("idCard") String idCard);
}
