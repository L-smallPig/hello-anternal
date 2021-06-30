package com.pro.springboot.sql;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SqlScript {
    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SqlScript.class);

    private final static String DIR_PATH = "D:\\myfile\\";
    private final static String OUT_FILE = DIR_PATH + "insertData.sql";

    public static void main(String[] args) throws IOException {
        jsonToSql("jsonFile.json");
    }

    private static void jsonToSql(String fileName) throws IOException {
        long start = System.currentTimeMillis();
        File file = new File(DIR_PATH + fileName);
        if (!file.exists()) {
            LOGGER.info("File is not exist!");
            return;
        }
        String jsonString = FileUtils.readFileToString(file, "utf-8");
        List<Map> mapList = JSON.parseArray(jsonString.trim(), Map.class);
        StringBuilder sb = new StringBuilder();
        for (Map map : mapList)
        {
            sb.append("insert into (");
            Set<String> keySet = map.keySet();
            keySet.forEach(key -> {
                sb.append("\""+key.replace(" ","").toUpperCase()+"\",");
            });
            sb.deleteCharAt(sb.length() - 1);
            sb.append(") values (");
            Collection valueList = map.values();
            valueList.forEach(value -> {
                if(value.getClass().equals(Integer.class)) { //Integer类型
                    sb.append(value + ",");
                } else {
                    sb.append("\"" + value.toString().replace(" ", "") + "\",");
                }
            });
            sb.deleteCharAt(sb.length() - 1);
            sb.append("); \n");
        }

        // 写文件
        FileUtils.writeStringToFile(new File(OUT_FILE),sb.toString(), Charset.defaultCharset());
        long end = System.currentTimeMillis();
        LOGGER.info("消耗时长：|{}", end-start);
    }
}
