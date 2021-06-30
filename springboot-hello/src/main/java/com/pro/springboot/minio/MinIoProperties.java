package com.pro.springboot.minio;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @className: MinIoProperties
 * @description: minio 配置类
 * @author: liguangyue
 * @date: 2021/3/25 15:08
 **/
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "minio")
public class MinIoProperties {

    /**
     * minio地址+端口号
     */
    private String endpoint;

    /**
     * TCP/IP端口号
     */
    private int port;

    /**
     * minio用户名
     */
    private String accessKey;

    /**
     * minio密码
     */
    private String secretKey;

    /**
     * 文件桶的名称
     */
    private String bucketName;

    /**
     * 如果是true，则用的是https而不是http,默认值是true
     */
    private Boolean secure;

    @Bean
    public MinioClient getMinIoClient() throws InvalidEndpointException, InvalidPortException {
        MinioClient minioClient = new MinioClient(endpoint, port, accessKey, secretKey, secure);
        return minioClient;
    }
}
