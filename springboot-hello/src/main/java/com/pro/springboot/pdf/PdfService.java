package com.pro.springboot.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @className: CreatePdfText
 * @description: 创建pdf文件
 * @author: liguangyue
 * @date: 2021/1/29 17:57
 **/
public interface PdfService {

    /**
    *
    * @description: 创建pdf
    * @author: liguangyue
    * @param: NONE
    * @return: String
    * @date: 2021/2/1 9:11
    **/
    void createPdf() throws DocumentException, FileNotFoundException;

    void generatePDF(HttpServletResponse response);
}
