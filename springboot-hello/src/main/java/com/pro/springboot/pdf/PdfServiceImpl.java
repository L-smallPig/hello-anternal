package com.pro.springboot.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.pro.springboot.result.CommonError;
import com.pro.springboot.result.MyException;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @className: PdfServiceImpl
 * @description: pdf 服务
 * @author: liguangyue
 * @date: 2021/2/1 9:05
 **/
@Service
public class PdfServiceImpl implements PdfService{

    private static final Logger LOGGER = LoggerFactory.getLogger(PdfServiceImpl.class);

    public static void main(String[] args) {
        System.out.println("===========start=============");
        try {
            PdfServiceImpl pdfService = new PdfServiceImpl();
            pdfService.createPdf();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===========end=============");
    }


    /**
     *
     * @description: 创建一个pdf并打开
     * @author: liguangyue
     * @param: NONE
     * @return: PdfWriter
     * @date: 2021/2/1 9:23
     **/
    public Document createDocument(HttpServletResponse response){
        try (OutputStream out = response.getOutputStream()){
            //页面大小
            Rectangle rect = new Rectangle(PageSize.A4);//文档竖方向
            //如果没有则创建
            Document doc = new Document(rect);
            PdfWriter writer = PdfWriter.getInstance(doc, out);
            //PDF版本(默认1.4)
            writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);
            //文档属性
            doc.addTitle("Title@wpixel");
            doc.addAuthor("Author@wpixel");
            doc.addSubject("Subject@wpixel");
            doc.addKeywords("Keywords@wpixel");
            doc.addCreator("Creator@wpixel");
            //页边空白
            doc.setMargins(40, 40, 40, 40);
            //打开文档
            doc.open();
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(CommonError.ERROR.msg());
        }
    }

    /**
     *
     * @description: 创建一个pdf并打开
     * @author: liguangyue
     * @param: NONE
     * @return: PdfWriter
     * @date: 2021/2/1 9:23
     **/
    public Document getDocument(){
        File file = new File("D:\\myfile\\aa.pdf");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //页面大小
            Rectangle rect = new Rectangle(PageSize.A4);//文档竖方向
            //如果没有则创建
            Document doc = new Document(rect);
            PdfWriter writer = PdfWriter.getInstance(doc, fos);
            //PDF版本(默认1.4)
            writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);
            //文档属性
            doc.addTitle("Title@wpixel");
            doc.addAuthor("Author@wpixel");
            doc.addSubject("Subject@wpixel");
            doc.addKeywords("Keywords@wpixel");
            doc.addCreator("Creator@wpixel");
            //页边空白
            doc.setMargins(40, 40, 40, 40);
            //打开文档
            doc.open();
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(CommonError.ERROR.msg());
        }
    }

    /**
    *
    * @description: 创建一个pdf并打开
    * @author: liguangyue
    * @param: NONE
    * @return: PdfWriter
    * @date: 2021/2/1 9:23
    **/
    @Override
    public void createPdf() throws DocumentException{
        Document doc = getDocument();
        createFile(doc);
        doc.close();
    }

    @Override
    public void generatePDF(HttpServletResponse response) {
        try {
            getPdf(response);
        }catch(Exception e) {
            LOGGER.error("PDF异常", e);
            throw new MyException(CommonError.ERROR.msg());
        }
    }

    /**
    *
    * @description: 创建pdf内容
    * @author: liguangyue
    * @param: doc pdf文件
    * @return: void
    * @date: 2021/2/1 9:24
    **/
    private void createFile(Document doc) throws DocumentException{
        doc.add(PdfFontUtils.getFont(1, "合作协议"));
        doc.add(PdfFontUtils.getFont(6, "甲方：大公司有限公司"));
        doc.add(PdfFontUtils.getFont(6, "乙方：小公司科技有限公司"));
        doc.add(PdfFontUtils.getFont(6, "时间：2020-02-10"));
        doc.add(PdfFontUtils.getFont(6, "地点：南京金陵大酒店"));
        Paragraph text05 = PdfFontUtils.getFont(5, "《根据中华人民共和国合同法》的有关规定，经甲、乙双方友好协商，本着长期平等合作，平等公平自由原则进行合作。");
        doc.add(text05);

        //一、合作方式及条件
        doc.add(PdfFontUtils.getFont(2, "一、合作方式及条件"));
        doc.add(PdfFontUtils.getFont(5, "1.双方根据国家法律规定建立合作关系，双方严格遵守和执行国家各项方针政策和有关法律、法规和条例规定。 "));
        doc.add(PdfFontUtils.getFont(5, "2.双方严格按照《中华人民共和国招标投标法》及相关规定实施合作。 "));
        doc.add(PdfFontUtils.getFont(5, "3.双方本着密切配合、分工协作、保证质量、按期完成的原则，共同做好工作。 "));

        //二、权利义务
        doc.add(PdfFontUtils.getFont(2, "二、权利义务"));
        doc.add(PdfFontUtils.getFont(5, "1.双方根据国家法律规定建立合作关系，双方严格遵守和执行国家各项方针政策和有关法律、法规和条例规定。 "));
        doc.add(PdfFontUtils.getFont(5, "2.双方严格按照《中华人民共和国招标投标法》及相关规定实施合作。 "));
        doc.add(PdfFontUtils.getFont(5, "3.双方本着密切配合、分工协作、保证质量、按期完成的原则，共同做好工作。 "));

        //三、其他
        doc.add(PdfFontUtils.getFont(2, "三、其他"));
        doc.add(PdfFontUtils.getFont(5, "1.双方根据国家法律规定建立合作关系，双方严格遵守和执行国家各项方针政策和有关法律、法规和条例规定。 "));
        doc.add(PdfFontUtils.getFont(5, "2.双方严格按照《中华人民共和国招标投标法》及相关规定实施合作。 "));
        doc.add(PdfFontUtils.getFont(5, "3.自定义 "));

        PdfPTable table = new PdfPTable(2);
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        PdfPCell cell = new PdfPCell();
        setValue(cell,table,"甲方：（盖章）");
        setValue(cell,table,"乙方：（盖章）");
        setValue(cell,table,"法定代表人或负责人签章");
        setValue(cell,table,"法定代表人或负责人签章");
        setValue(cell,table,"地址：珠江路1号");
        setValue(cell,table,"地址：珠江路3号");
        setValue(cell,table,"开户银行：中国银行");
        setValue(cell,table,"开户银行：中国农业银行");
        setValue(cell,table,"邮编：223315");
        setValue(cell,table,"邮编：223314");
        setValue(cell,table,"授权代理人：大公司");
        setValue(cell,table,"项目经理：小公司");
        setValue(cell,table,"电话：232332343441");
        setValue(cell,table,"电话：323232323434");
        doc.add(table);
    }

    /**
    *
    * @description: 塞入pdf内容
    * @author: liguangyue
    * @param: cell
    * @param table
    * @param text
    * @return: void
    * @date: 2021/2/1 9:24
    **/
    public void setValue(PdfPCell cell, PdfPTable table, String text)
    {
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, text)));
        cell.setColspan(1);
        cell.setBorder(0);
        table.addCell(cell);
    }


    public void getPdf(HttpServletResponse response) throws IOException, DocumentException {
        //页面大小
        Rectangle rect = new Rectangle(PageSize.A4);//文档竖方向
        //如果没有则创建
        Document doc = new Document(rect);
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(doc, bas);
        //PDF版本(默认1.4)
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);
        //文档属性
        doc.addTitle("Title@wpixel");
        doc.addAuthor("Author@wpixel");
        doc.addSubject("Subject@wpixel");
        doc.addKeywords("Keywords@wpixel");
        doc.addCreator("Creator@wpixel");
        //页边空白
        doc.setMargins(40, 40, 40, 40);
        //打开文档
        doc.open();
        createFile(doc);
        PdfStream pdfStream = new PdfStream(bas.toByteArray());
        PdfWriter pw =null;
        try {
            pw = PdfWriter.getInstance(doc, bas);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        OutputStream out = response.getOutputStream();
        pdfStream.toPdf(pw,out);
        pw.flush();
        bas.close();
        pw.close();
    }

}
