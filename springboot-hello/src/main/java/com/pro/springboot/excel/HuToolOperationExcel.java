package com.pro.springboot.excel;

import cn.hutool.core.io.file.FileWriter;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Description 使用Hutool 操作excel
 * @Author liguangyue [10733]
 * @Date 2020-12-01
 * @Copyright 2020-2025
 */
public class HuToolOperationExcel {

    /**
     * logger 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateTableUtils.class);

    /**
     * 读取文件地址
     */
    private static final String FILE_PATH = "D:/myfile/demo.xlsx";

    /**
     * 保存文件地址
     */
    private static final String SAVE_PATH = "D:/myfile/save.doc";

    /**
     * 数据库名
     */
    private static final String DATA_BASE = "\"HISTEST\"";

    /**
     * 表名
     */
    private static final String TABLE_NAME = "\"USER_ONE\"";


    /**
     *  HuTool操作excel
     */
    public static void operationExcel()
    {
        StringBuilder createStr = new StringBuilder();
        StringBuilder commentStr = new StringBuilder();
        createStr.append("create table "+DATA_BASE + "." +TABLE_NAME +"\n");
        createStr.append("( \n");

        // 读取excel文件
        readExcel(createStr, commentStr);

        // 写入文件
        writeFile(createStr, commentStr);
    }

    /**
     * 读取excel文件
     *
     * @param createStr 建表语句
     * @param commentStr 字段注释
     */
    public static void readExcel(StringBuilder createStr, StringBuilder commentStr)
    {
        ExcelReader reader = ExcelUtil.getReader(FILE_PATH);
        List<ExcelModel> excelList = reader.readAll(ExcelModel.class);
        excelList.forEach(excelModel -> {
            createStr.append(excelModel.getFieldName() + " " + excelModel.getDataType());
            if (!StringUtils.isEmpty(excelModel.getAttribute()) && excelModel.getAttribute().contains("主键")) {
                createStr.append("  primary key ");
            }
            if (!StringUtils.isEmpty(excelModel.getAttribute()) && excelModel.getAttribute().contains("必填")) {
                createStr.append(" not null");
            }
            createStr.append(", \n");
            commentStr.append("comment on column "+DATA_BASE + "." +TABLE_NAME+"."+"\""
                    +excelModel.getFieldName()+"\""+" is "+
                    "'"+excelModel.getNotes()+"'; \n");
        });
        createStr.substring(0, createStr.length()-1);
        createStr.append(" );");
    }

    /**
     * 建表语句写入文件中
     *
     * @param createStr 建表语句
     * @param commentStr 字段注释
     */
    public static void writeFile(StringBuilder createStr, StringBuilder commentStr)
    {
        StringBuilder sdf = new StringBuilder();
        FileWriter writer = new FileWriter(SAVE_PATH);
        sdf.append("==============建表语句==============\n");
        sdf.append(createStr.toString());
        sdf.append("\n");
        sdf.append("==============字段注释==============\n");
        sdf.append(commentStr.toString());
        writer.write(sdf.toString());
    }

    public static void main(String[] args) {
        operationExcel();
    }

}
