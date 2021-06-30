package com.pro.springboot.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 监听器
 * @Author liguangyue [10733]
 * @Date 2020-12-02
 * @Copyright 2020-2025
 */
public class ExcelModelListener extends AnalysisEventListener<ExcelModel> {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelModelListener.class);

    List<ExcelModel> list = new ArrayList<ExcelModel>();

    public ExcelModelListener() {}


    @Override
    public void invoke(ExcelModel excelModel, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(excelModel));
        list.add(excelModel);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println(JSON.toJSONString(list));
    }
}
