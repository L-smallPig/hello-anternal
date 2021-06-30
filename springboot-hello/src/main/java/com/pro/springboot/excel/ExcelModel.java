package com.pro.springboot.excel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description Excel Model
 * @Author liguangyue [10733]
 * @Date 2020-12-02
 * @Copyright 2020-2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelModel {

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 中文名称
     */
    private String notes;

    /**
     * 属性
     */
    private String attribute;

}
