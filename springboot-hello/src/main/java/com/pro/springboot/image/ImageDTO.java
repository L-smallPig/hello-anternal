package com.pro.springboot.image;

import lombok.Data;

/**
 * @ClassName ImageDTO
 * @Description 图片实体类
 * @Author liguangyue
 * @Date 2021/4/14 11:43
 * @Version 1.0
 **/
@Data
public class ImageDTO {

    private Integer id;
    private String idCard;
    private String name;
    private byte[] image;
    private String imageType;
    private String updateDate;
    private String imageNo;
    private String jlUpdate;
}
