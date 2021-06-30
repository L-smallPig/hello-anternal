package com.pro.springboot.excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Description 根据 excel生成 oracle 建表语句
 * @Author liguangyue [10733]
 * @Date 2020-12-01
 * @Copyright 2020-2025
 */
public class CreateTableUtils {

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
    private static final String SAVE_PATH = "D:/myfile/create.docx";

    /**
     * 常量 1
     */
    private static final int ONE = 1;

    /**
     * 常量 2
     */
    private static final int TWO = 2;

    /**
     * 常量 3
     */
    private static final int THREE = 3;

    /**
     * 常量 0
     */
    private static final int ZERO = 0;


    /**
    *
    * @description: 根据excel生成建表语句
     * sheet 名称就是表名称
    * @author: liguangyue
    * @param: NONE
    * @return: void
    * @date: 2021/1/26 18:07
    **/
    public static void readExcel()
    {

//        excel 示例
//        fieldName	    dataType	    notes	    attribute
//        USER_ID	    VARCHAR2(36)	用户id	    主键，唯一id，必填
//        USER_NAME	    VARCHAR2(50)	用户名称	必填
//        USER_SEX	    CHAR(1)	        用户性别
//        USER_AGE	    NUMBER(3)	    用户年龄
//        USER_WEIGHT	NUMBER(4,2)	    用户体重
//        USER_HEIGHT	NUMBER(3,2)	    用户身高

        File file = new File(SAVE_PATH);
        if (!file.exists() || !file.isFile())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                LOGGER.warn("创建文件失败！", e.getMessage());
            }
        }

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             FileOutputStream fos = new FileOutputStream(file)){
            //创建工作簿
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
            for (int sheetIndex = 0; sheetIndex < xssfWorkbook.getNumberOfSheets(); sheetIndex++) {
                //读取第一个工作表
                XSSFSheet sheet = xssfWorkbook.getSheetAt(sheetIndex);
                String tableName = sheet.getSheetName();
                StringBuilder createStr = new StringBuilder();
                StringBuilder commentStr = new StringBuilder();
                createStr.append("create table "+tableName +"\n");
                createStr.append("( \n");
                //获取最后一行的num，即总行数。此处从0开始计数
                int maxRow = sheet.getLastRowNum();
                LOGGER.info("总行数为：|{}", maxRow);
                for (int row = ONE; row <= maxRow; row++) {
                    String xssfCell = sheet.getRow(row).getCell(THREE) == null ? "" : String.valueOf(sheet.getRow(row).getCell(THREE));
                    if (xssfCell.contains("必填")) {
                        createStr.append(sheet.getRow(row).getCell(ZERO) + " "
                                + sheet.getRow(row).getCell(ONE) +"\t not null, \n");
                    }
                    else
                    {
                        createStr.append(sheet.getRow(row).getCell(ZERO) + " "
                                + sheet.getRow(row).getCell(ONE) + ",\n");
                    }
                    commentStr.append("comment on column " + "\'"+tableName+ "\'"+"."+"\'"
                            +sheet.getRow(row).getCell(ZERO).toString().trim()+"\'"+" is "+
                            "'"+sheet.getRow(row).getCell(TWO)+"'; \n");
                }
                StringBuilder createBuilder = new StringBuilder(createStr.substring(0, createStr.length()-2));
                createBuilder.append(" \n );");
                fos.write("==============建表语句==============\n".getBytes());
                fos.write(createBuilder.toString().getBytes());
                fos.write("\n".getBytes());
                fos.write("==============字段注释==============\n".getBytes());
                fos.write(commentStr.toString().getBytes());
            }
        } catch (IOException e) {
            LOGGER.warn("===出错了===|{}", e.getMessage());
        }
    }


    /**
    *
    * @description: main 方法 测试用
    * @author: liguangyue
    * @param: args
    * @return: void
    * @date: 2021/1/26 18:11
    **/
    public static void main(String[] args) {
//        readExcel();
        ExcelReader reader = ExcelUtil.getReader(FILE_PATH);
        for (int sheetIndex = 0; sheetIndex < reader.getSheetCount(); sheetIndex ++)
        {

            String tableName = reader.getSheet().getSheetName();
            List<ExcelModel> all = reader.readAll(ExcelModel.class);
            System.out.println(all);
        }
    }
}
