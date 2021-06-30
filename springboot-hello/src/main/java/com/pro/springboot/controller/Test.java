package com.pro.springboot.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Test
 * @Description 测试
 * @Author liguangyue
 * @Date 2021/4/15 17:47
 * @Version 1.0
 **/
public class Test {
    public static List<Map<String, String>> checkOrganCode(List<Map<String, String>> lists) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> map : lists) {
            if (!"320124011".equals(map.get("ORGAN_CODE"))
                    && !"320124010".equals(map.get("ORGAN_CODE"))
                    && !"320124009".equals(map.get("ORGAN_CODE"))) {
                map.put("ORGAN_CODE", "");
            }
            if (!result.contains(map)) {
                result.add(map);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Map<String, String>> phridMap = new ArrayList<>();
        Map<String, String> resultMap = new HashMap();
        resultMap.put("PHRID","146430");
        resultMap.put("ORGAN_CODE","19");
        phridMap.add(resultMap);
        List<Map<String, String>> aa = checkOrganCode(phridMap);
        System.out.println(aa);
    }


    /**
     * 通过 IP+端口 连接打印机打印文件
     * @param filePath
     * @throws Exception
     */
    public static void printFile(String filePath,String ip){
        try (Socket socket = new Socket(ip, 9100);
             OutputStream out = socket.getOutputStream()){
            //建立数组
            byte[] bytes = new byte[1024];
            //判断是否读到文件末尾
            out.write(bytes, 0, bytes.length);
            //告诉服务端，文件已传输完毕
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
