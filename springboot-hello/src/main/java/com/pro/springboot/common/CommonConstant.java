package com.pro.springboot.common;

import java.io.Serializable;

/**
 * @Description 公共常量类
 * @Author liguangyue
 * @Date 2020-02-23 17:04:06
 * @Copyright 2020-2025
 */
public class CommonConstant implements Serializable {


    /**
     * 常量 推送数据返回CODE
     */
    public static final String RESULT_CODE = "0000000000";

    /**
     * 失败返回CODE
     */
    public static final String ERROR_CODE = "999999";

    /**
     * 成功返回CODE
     */
    public static final String SUCCESS_CODE = "000000";

    /**
     * 检查数据推送接口返回码
     */
    public static final String INSPECT_SUCCESS = "000000";

    /**
     * 字符编码
     */
    public static final String UTF_8 = "UTF-8";

    /**
     * content_type
     */
    public static final String CONTENT_TYPE = "Content-Type";

    /**
     * content_type_value
     */
    public static final String CONTENT_TYPE_VALUE = "text/xml;charset=utf-8";

    /**
     * 头部请求信息
     */
    public static final String XML_HEAD = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.zhending.com\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n";

    /**
     * 尾部请求信息
     */
    public static final String XML_TAIL = "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";

    /**
     * 妇幼数据请求地址
     */
    public static final String REQUEST_URL = "http://11.53.38.15:18080/mchis-controller/services/Mchis?wsdl";

    /**
     * 常量 success
     */
    public static final String SUCCESS = "success";

    /**
     * 常量 result
     */
    public static final String RESULT = "result";

    /**
     * 常量 data
     */
    public static final String DATA = "data";

    /**
     * 常量 token
     */
    public static final String TOKEN = "token";

    /**
     * 用户名
     */
    public static final String LOGIN_CODE = "18051037533";

    /**
     * password
     */
    public static final String PASSWORD =  "abc@123@";

    /**
     * 溧水妇保所机构Code
     */
    public static final String LS_FBS_ORGAN_CODE = "sysOrganOrgan.OrganCode=320000000918";

}
