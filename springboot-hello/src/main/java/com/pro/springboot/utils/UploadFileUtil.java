package com.pro.springboot.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @Description 图片上传工具类
 * @Author liguangyue
 * @Date 2020-09-27
 * @Copyright 2020-2025
 */
public class UploadFileUtil {

    /**
     * 日志文件
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileUtil.class);


    /**
     * Description: 向FTP服务器上传文件
     * @Version1.0
     * @param url FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param path FTP服务器保存目录
     * @param filename 上传到FTP服务器上的文件名
     * @param input 输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(
            String url,//FTP服务器hostname
            int port,//FTP服务器端口
            String username, // FTP登录账号
            String password, //FTP登录密码
            String path, //FTP服务器保存目录
            String filename, //上传到FTP服务器上的文件名
            InputStream input // 输入流
    ) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(url, port);//连接FTP服务器
            //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);//登录
            reply = ftp.getReplyCode();
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                System.out.println("FTP服务器 拒绝连接");
                return success;
            }
            ftp.changeWorkingDirectory(path);
            ftp.storeFile(filename, input);

            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream(new File("D:\\png\\a.jpg"));
            boolean flag = uploadFile("192.168.10.137", 22, "root", "Password123$", "/bsoft/bhrview/image/", "a.jpg", in);
            System.out.println(flag);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
