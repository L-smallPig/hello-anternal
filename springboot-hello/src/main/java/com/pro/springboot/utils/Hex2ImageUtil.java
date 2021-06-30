package com.pro.springboot.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @ClassName: Hex2ImageUtil
 * @Description: 16进制转图片工具类
 * @Author: 【liguangyue】
 * @Date: 2020-12-16
 **/
public class Hex2ImageUtil {

    /**
     * @Description: 16进制转图片
     * @Author: liguangyue
     * @param src 16进制内容
     * @param output 输出文件
     * @Date: 2020-12-16
     */
    public static void saveToImgFile(String src,String output){
        if(src==null||src.length()==0){
            return;
        }
        try{
            FileOutputStream out = new FileOutputStream(new File(output));
            byte[] bytes = src.getBytes();
            for(int i=0;i<bytes.length;i+=2){
                out.write(charToInt(bytes[i])*16+charToInt(bytes[i+1]));
            }
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static int charToInt(byte ch){
        int val = 0;
        if(ch>=0x30&&ch<=0x39){
            val=ch-0x30;
        }else if(ch>=0x41&&ch<=0x46){
            val=ch-0x41+10;
        }
        return val;
    }

    public static void main(String[] args)throws Exception {
        String str = "";
        String aa = str.replace(" ","+");
        String bb = GZIPUtils.uncompress(aa);
        byte[] bytes = bb.getBytes();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<bytes.length;i+=2){
            sb.append(charToInt(bytes[i]) * 16 + charToInt(bytes[i+1]));
        }
        System.out.println(sb);
//       saveToImgFile(bb.toUpperCase(),"D://png//16.jpg");
    }
}
