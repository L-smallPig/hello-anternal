package com.pro.springboot.sql;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonToExcel {

    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SqlScript.class);

    private final static String DIR_PATH = "D:\\myfile\\";
    private final static String OUT_FILE = DIR_PATH + "insert.xlsx";

    private static String jsonString = "[{\"birthday\":642902400000,\"healthNo\":\"3201172001758\",\"organ\":\"南京市溧水区永阳街道社区卫生服务中心\",\"postDays\":6,\"sbp\":114,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610690707000,\"cut\":\"0\",\"inputDoctorCode\":\"320124197610081446\",\"sysId\":\"2486446d-6c61-423b-9cfa-83b13d4408bf\",\"updateDoctorCode\":\"320124197610081446\",\"updateDoctor\":\"张华\",\"visitLost\":\"0\",\"outHospDate\":1607961600000,\"cardNo\":\"320124199005173229\",\"fu\":\"01\",\"guideFeed\":\"1\",\"inputDoctor\":\"张华\",\"lochia\":\"0\",\"organCode\":\"320000003918\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1607529600000,\"tran\":\"0\",\"nextDate\":1609948800000,\"temp\":36.3,\"inputOrgan\":\"南京市溧水区永阳街道社区卫生服务中心\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区永阳街道社区卫生服务中心\",\"cardType\":\"01\",\"nextCheck\":\"0\",\"checkDate\":1608480000000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"钱君香\",\"inputOrganCode\":\"320000003918\",\"guidePsycho\":\"1\",\"dbp\":76,\"healthStatus\":\"0\",\"idcard\":\"320124199005173229\",\"updateOrganCode\":\"320000003918\",\"doctorCode\":\"320124196410171442\",\"name\":\"章欧\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":793238400000,\"healthNo\":\"3201172002118\",\"organ\":\"南京市溧水区洪蓝街道卫生院\",\"postDays\":3,\"sbp\":90,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610687546000,\"cut\":\"0\",\"inputDoctorCode\":\"320123197909120028\",\"sysId\":\"cd779266-6e8f-444d-8b4c-53fb933add2c\",\"updateDoctorCode\":\"320123197909120028\",\"updateDoctor\":\"任琴\",\"visitLost\":\"0\",\"outHospDate\":1610414445000,\"cardNo\":\"320124199502201622\",\"fu\":\"12\",\"guideFeed\":\"1\",\"inputDoctor\":\"任琴\",\"lochia\":\"0\",\"organCode\":\"320000003924\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1610056080000,\"tran\":\"0\",\"nextDate\":1612475280000,\"temp\":36.7,\"inputOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"cardType\":\"01\",\"nextCheck\":\"0\",\"checkDate\":1610640000000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"任琴\",\"inputOrganCode\":\"320000003924\",\"guidePsycho\":\"1\",\"dbp\":70,\"healthStatus\":\"0\",\"idcard\":\"320124199502201622\",\"updateOrganCode\":\"320000003924\",\"doctorCode\":\"320123197909120028\",\"name\":\"胡文娟\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":541555200000,\"healthNo\":\"3201172001339\",\"organ\":\"南京市溧水区永阳街道社区卫生服务中心\",\"postDays\":4,\"sbp\":118,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610690960000,\"cut\":\"0\",\"inputDoctorCode\":\"320124197610081446\",\"sysId\":\"c3733ecf-da7f-41df-a9fd-ee6f79052f03\",\"updateDoctorCode\":\"320124197610081446\",\"updateDoctor\":\"张华\",\"visitLost\":\"0\",\"outHospDate\":1608220800000,\"cardNo\":\"320124198703011628\",\"fu\":\"02\",\"guideFeed\":\"1\",\"inputDoctor\":\"张华\",\"lochia\":\"0\",\"organCode\":\"320000003918\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1607961240000,\"tran\":\"0\",\"nextDate\":1610380440000,\"temp\":36.1,\"inputOrgan\":\"南京市溧水区永阳街道社区卫生服务中心\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区永阳街道社区卫生服务中心\",\"cardType\":\"01\",\"nextCheck\":\"0\",\"checkDate\":1608566400000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"钱君香\",\"inputOrganCode\":\"320000003918\",\"guidePsycho\":\"1\",\"dbp\":76,\"healthStatus\":\"0\",\"idcard\":\"320124198703011628\",\"updateOrganCode\":\"320000003918\",\"doctorCode\":\"320124196410171442\",\"name\":\"颜艳\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":699926400000,\"healthNo\":\"3201172001962\",\"organ\":\"南京市溧水区洪蓝街道卫生院\",\"postDays\":5,\"sbp\":111,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610687738000,\"cut\":\"0\",\"inputDoctorCode\":\"320123197909120028\",\"sysId\":\"138b6fee-1ec4-4cd8-bb00-80f869e58b8e\",\"updateDoctorCode\":\"320123197909120028\",\"updateDoctor\":\"任琴\",\"visitLost\":\"0\",\"outHospDate\":1610035200000,\"cardNo\":\"511502199203076606\",\"fu\":\"08\",\"guideFeed\":\"1\",\"inputDoctor\":\"任琴\",\"lochia\":\"0\",\"organCode\":\"320000003924\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1609729380000,\"tran\":\"0\",\"nextDate\":1612148580000,\"temp\":36.9,\"inputOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"cardType\":\"01\",\"nextCheck\":\"0\",\"checkDate\":1610467200000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"任琴\",\"inputOrganCode\":\"320000003924\",\"guidePsycho\":\"1\",\"dbp\":63,\"healthStatus\":\"0\",\"idcard\":\"511502199203076606\",\"updateOrganCode\":\"320000003924\",\"doctorCode\":\"320123197909120028\",\"name\":\"闵娟\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":430012800000,\"healthNo\":\"3201172001877\",\"organ\":\"南京市溧水区洪蓝街道卫生院\",\"postDays\":23,\"sbp\":96,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610688595000,\"cut\":\"0\",\"inputDoctorCode\":\"320123197909120028\",\"sysId\":\"13ae27c7-bb55-4f83-b7b4-ce9dc765e821\",\"updateDoctorCode\":\"320123197909120028\",\"updateDoctor\":\"任琴\",\"visitLost\":\"0\",\"outHospDate\":1608307200000,\"cardNo\":\"320124198308182224\",\"fu\":\"12\",\"guideFeed\":\"1\",\"inputDoctor\":\"任琴\",\"lochia\":\"0\",\"organCode\":\"320000003924\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1607883720000,\"tran\":\"0\",\"nextDate\":1611512520000,\"temp\":36.9,\"inputOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"cardType\":\"01\",\"nextCheck\":\"1\",\"checkDate\":1610294400000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"任琴\",\"inputOrganCode\":\"320000003924\",\"guidePsycho\":\"1\",\"dbp\":62,\"healthStatus\":\"0\",\"idcard\":\"320124198308182224\",\"updateOrganCode\":\"320000003924\",\"doctorCode\":\"320123197909120028\",\"name\":\"邱玲玲\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":694310400000,\"healthNo\":\"3201172001813\",\"organ\":\"南京市溧水区洪蓝街道卫生院\",\"postDays\":2,\"sbp\":95,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610687618000,\"cut\":\"0\",\"inputDoctorCode\":\"320123197909120028\",\"sysId\":\"74c34b58-cdae-41ba-a45c-15302a79db2a\",\"updateDoctorCode\":\"320123197909120028\",\"updateDoctor\":\"任琴\",\"visitLost\":\"0\",\"outHospDate\":1610467200000,\"cardNo\":\"320826199201024221\",\"fu\":\"12\",\"guideFeed\":\"1\",\"inputDoctor\":\"任琴\",\"lochia\":\"0\",\"organCode\":\"320000003924\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1610075280000,\"tran\":\"0\",\"nextDate\":1612494480000,\"temp\":36.9,\"inputOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"cardType\":\"01\",\"nextCheck\":\"0\",\"checkDate\":1610640000000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"任琴\",\"inputOrganCode\":\"320000003924\",\"guidePsycho\":\"1\",\"dbp\":66,\"healthStatus\":\"0\",\"idcard\":\"320826199201024221\",\"updateOrganCode\":\"320000003924\",\"doctorCode\":\"320123197909120028\",\"name\":\"郑红\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":642902400000,\"healthNo\":\"3201172001758\",\"organ\":\"南京市溧水区永阳街道社区卫生服务中心\",\"postDays\":24,\"sbp\":120,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610690729000,\"cut\":\"0\",\"inputDoctorCode\":\"320124197610081446\",\"sysId\":\"15391a41-84e2-4b51-b8de-b3e02289af00\",\"updateDoctorCode\":\"320124197610081446\",\"updateDoctor\":\"张华\",\"visitLost\":\"0\",\"outHospDate\":1607961600000,\"cardNo\":\"320124199005173229\",\"fu\":\"06\",\"guideFeed\":\"1\",\"inputDoctor\":\"张华\",\"lochia\":\"0\",\"organCode\":\"320000003918\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1607529600000,\"tran\":\"0\",\"nextDate\":1611158400000,\"temp\":36.3,\"inputOrgan\":\"南京市溧水区永阳街道社区卫生服务中心\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区永阳街道社区卫生服务中心\",\"cardType\":\"01\",\"nextCheck\":\"1\",\"checkDate\":1610035200000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"钱君香\",\"inputOrganCode\":\"320000003918\",\"guidePsycho\":\"1\",\"dbp\":60,\"healthStatus\":\"0\",\"idcard\":\"320124199005173229\",\"updateOrganCode\":\"320000003918\",\"doctorCode\":\"320124196410171442\",\"name\":\"章欧\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":720835200000,\"healthNo\":\"3201172001318\",\"organ\":\"南京市溧水区白马中心卫生院\",\"postDays\":3,\"sbp\":110,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610670802000,\"cut\":\"0\",\"inputDoctorCode\":\"320124197907063249\",\"sysId\":\"b6249ea5-1aed-4910-8ad0-5cf39f6dc275\",\"updateDoctorCode\":\"320124197907063249\",\"updateDoctor\":\"韦白娣\",\"visitLost\":\"0\",\"outHospDate\":1608307200000,\"cardNo\":\"320124199211040021\",\"fu\":\"06\",\"guideFeed\":\"1\",\"inputDoctor\":\"韦白娣\",\"lochia\":\"0\",\"organCode\":\"320000003908\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1608048000000,\"tran\":\"0\",\"nextDate\":1611676800000,\"temp\":36.7,\"inputOrgan\":\"南京市溧水区白马中心卫生院\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区白马中心卫生院\",\"cardType\":\"01\",\"nextCheck\":\"1\",\"checkDate\":1608566400000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"韦白娣\",\"inputOrganCode\":\"320000003908\",\"guidePsycho\":\"1\",\"dbp\":80,\"healthStatus\":\"0\",\"idcard\":\"320124199211040021\",\"updateOrganCode\":\"320000003908\",\"doctorCode\":\"320124197907063249\",\"name\":\"陈白琳\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":771292800000,\"healthNo\":\"3201172002160\",\"organ\":\"南京市溧水区洪蓝街道卫生院\",\"postDays\":4,\"sbp\":100,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610687664000,\"cut\":\"0\",\"inputDoctorCode\":\"320123197909120028\",\"sysId\":\"f1673531-c601-4e59-8bef-9048830fb537\",\"updateDoctorCode\":\"320123197909120028\",\"updateDoctor\":\"任琴\",\"visitLost\":\"0\",\"outHospDate\":1610035200000,\"cardNo\":\"32012419940611182X\",\"fu\":\"12\",\"guideFeed\":\"1\",\"inputDoctor\":\"任琴\",\"lochia\":\"0\",\"organCode\":\"320000003924\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1609689600000,\"tran\":\"0\",\"nextDate\":1612108800000,\"temp\":36.5,\"inputOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"cardType\":\"01\",\"nextCheck\":\"0\",\"checkDate\":1610380800000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"任琴\",\"inputOrganCode\":\"320000003924\",\"guidePsycho\":\"1\",\"dbp\":66,\"healthStatus\":\"0\",\"idcard\":\"32012419940611182X\",\"updateOrganCode\":\"320000003924\",\"doctorCode\":\"320123197909120028\",\"name\":\"张鸿\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":612835200000,\"healthNo\":\"3201172001948\",\"organ\":\"南京市溧水区洪蓝街道卫生院\",\"postDays\":23,\"sbp\":100,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610688660000,\"cut\":\"0\",\"inputDoctorCode\":\"320123197909120028\",\"sysId\":\"21c096e4-833e-4ab3-9a93-c9e0c1a78afc\",\"updateDoctorCode\":\"320123197909120028\",\"updateDoctor\":\"任琴\",\"visitLost\":\"0\",\"outHospDate\":1608519638000,\"cardNo\":\"320821198906030326\",\"fu\":\"06\",\"guideFeed\":\"1\",\"inputDoctor\":\"任琴\",\"lochia\":\"0\",\"organCode\":\"320000003924\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1608048000000,\"tran\":\"0\",\"nextDate\":1611676800000,\"temp\":36.5,\"inputOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"cardType\":\"01\",\"nextCheck\":\"1\",\"checkDate\":1610467200000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"任琴\",\"inputOrganCode\":\"320000003924\",\"guidePsycho\":\"1\",\"dbp\":62,\"healthStatus\":\"0\",\"idcard\":\"320821198906030326\",\"updateOrganCode\":\"320000003924\",\"doctorCode\":\"320123197909120028\",\"name\":\"李新云\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":541555200000,\"healthNo\":\"3201172001339\",\"organ\":\"南京市溧水区永阳街道社区卫生服务中心\",\"postDays\":26,\"sbp\":130,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610690984000,\"cut\":\"0\",\"inputDoctorCode\":\"320124197610081446\",\"sysId\":\"bd30dad7-ebee-4f7c-a656-159f6e7fe44a\",\"updateDoctorCode\":\"320124197610081446\",\"updateDoctor\":\"张华\",\"visitLost\":\"0\",\"outHospDate\":1608220800000,\"cardNo\":\"320124198703011628\",\"fu\":\"06\",\"guideFeed\":\"1\",\"inputDoctor\":\"张华\",\"lochia\":\"0\",\"organCode\":\"320000003918\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1607961240000,\"tran\":\"0\",\"nextDate\":1611590040000,\"temp\":36.4,\"inputOrgan\":\"南京市溧水区永阳街道社区卫生服务中心\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区永阳街道社区卫生服务中心\",\"cardType\":\"01\",\"nextCheck\":\"1\",\"checkDate\":1610467200000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"钱君香\",\"inputOrganCode\":\"320000003918\",\"guidePsycho\":\"1\",\"dbp\":80,\"healthStatus\":\"0\",\"idcard\":\"320124198703011628\",\"updateOrganCode\":\"320000003918\",\"doctorCode\":\"320124196410171442\",\"name\":\"颜艳\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":444787200000,\"healthNo\":\"3201172001727\",\"organ\":\"南京市溧水区洪蓝街道卫生院\",\"postDays\":23,\"sbp\":102,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610688538000,\"cut\":\"0\",\"inputDoctorCode\":\"320123197909120028\",\"sysId\":\"41ef6b4c-1f81-4a7a-b399-ba2839868f21\",\"updateDoctorCode\":\"320123197909120028\",\"updateDoctor\":\"任琴\",\"visitLost\":\"0\",\"outHospDate\":1608393600000,\"cardNo\":\"341224198402053365\",\"fu\":\"06\",\"guideFeed\":\"1\",\"inputDoctor\":\"任琴\",\"lochia\":\"0\",\"organCode\":\"320000003924\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1608025440000,\"tran\":\"0\",\"nextDate\":1611654240000,\"temp\":36.9,\"inputOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区洪蓝街道卫生院\",\"cardType\":\"01\",\"nextCheck\":\"1\",\"checkDate\":1610380800000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"任琴\",\"inputOrganCode\":\"320000003924\",\"guidePsycho\":\"1\",\"dbp\":66,\"healthStatus\":\"0\",\"idcard\":\"341224198402053365\",\"updateOrganCode\":\"320000003924\",\"doctorCode\":\"320123197909120028\",\"name\":\"许文\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":720835200000,\"healthNo\":\"3201172001318\",\"organ\":\"南京市溧水区白马中心卫生院\",\"postDays\":26,\"sbp\":110,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610670824000,\"cut\":\"0\",\"inputDoctorCode\":\"320124197907063249\",\"sysId\":\"cc991fe3-716a-4dba-a373-eb8009940808\",\"updateDoctorCode\":\"320124197907063249\",\"updateDoctor\":\"韦白娣\",\"visitLost\":\"0\",\"outHospDate\":1608307200000,\"cardNo\":\"320124199211040021\",\"fu\":\"06\",\"guideFeed\":\"1\",\"inputDoctor\":\"韦白娣\",\"lochia\":\"0\",\"organCode\":\"320000003908\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1608048000000,\"tran\":\"0\",\"nextDate\":1611676800000,\"temp\":36.5,\"inputOrgan\":\"南京市溧水区白马中心卫生院\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区白马中心卫生院\",\"cardType\":\"01\",\"nextCheck\":\"1\",\"checkDate\":1610553600000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"韦白娣\",\"inputOrganCode\":\"320000003908\",\"guidePsycho\":\"1\",\"dbp\":75,\"healthStatus\":\"0\",\"idcard\":\"320124199211040021\",\"updateOrganCode\":\"320000003908\",\"doctorCode\":\"320124197907063249\",\"name\":\"陈白琳\",\"uterine\":\"0\",\"breast\":\"0\"},\n" +
            "{\"birthday\":691545600000,\"healthNo\":\"3201142002184\",\"organ\":\"南京市溧水区永阳街道社区卫生服务中心\",\"postDays\":25,\"sbp\":110,\"classify\":\"0\",\"tbKey\":\"0\",\"updateDate\":1610690575000,\"cut\":\"0\",\"inputDoctorCode\":\"320124197610081446\",\"sysId\":\"a42f36f1-5f80-48c3-8791-abb68e069457\",\"updateDoctorCode\":\"320124197610081446\",\"updateDoctor\":\"张华\",\"visitLost\":\"0\",\"outHospDate\":1608393600000,\"cardNo\":\"320124199112011620\",\"fu\":\"06\",\"guideFeed\":\"1\",\"inputDoctor\":\"张华\",\"lochia\":\"0\",\"organCode\":\"320000003918\",\"guideNutrition\":\"1\",\"psychologicStatus\":\"0\",\"deliveryDate\":1608048000000,\"tran\":\"0\",\"nextDate\":1611676800000,\"temp\":36.5,\"inputOrgan\":\"南京市溧水区永阳街道社区卫生服务中心\",\"guideHygiene\":\"1\",\"updateOrgan\":\"南京市溧水区永阳街道社区卫生服务中心\",\"cardType\":\"01\",\"nextCheck\":\"1\",\"checkDate\":1610553600000,\"inputDate\":1610640000000,\"dbKey\":\"0\",\"guideBreast\":\"1\",\"doctor\":\"钱君香\",\"inputOrganCode\":\"320000003918\",\"guidePsycho\":\"1\",\"dbp\":74,\"healthStatus\":\"0\",\"idcard\":\"320124199112011620\",\"updateOrganCode\":\"320000003918\",\"doctorCode\":\"320124196410171442\",\"name\":\"蔡孟君\",\"uterine\":\"0\",\"breast\":\"0\"}]\n";

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
                sb.append(key.replace(" ","")+",");
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

//        // 写文件
        FileUtils.writeStringToFile(new File(OUT_FILE),sb.toString(), Charset.defaultCharset());
        long end = System.currentTimeMillis();
        LOGGER.info("消耗时长：|{}", end-start);
    }

    private static void toSql(){
        long start = System.currentTimeMillis();

        List<Map> mapList = JSON.parseArray(jsonString.trim(), Map.class);
        StringBuilder sb = new StringBuilder();
        for (Map map : mapList)
        {
            sb.append("insert into (");
            Set<String> keySet = map.keySet();
            keySet.forEach(key -> {
                sb.append(key.replace(" ","")+",");
            });
            sb.deleteCharAt(sb.length() - 1);
            sb.append(") values (");
            Collection valueList = map.values();
            valueList.forEach(value -> {
                if(value.getClass().equals(Integer.class)) { //Integer类型
                    sb.append(value + ",");
                } else if (value.getClass().equals(Double.class)){
                    sb.append(value + ",");
                } else if (value.getClass().equals(BigDecimal.class)){
                    sb.append(value + ",");
                } else {
                    sb.append("'" + value.toString().replace(" ", "") + "',");
                }
            });
            sb.deleteCharAt(sb.length() - 1);
            sb.append("); \n");
        }
        System.out.println(sb.toString());
        long end = System.currentTimeMillis();
        LOGGER.info("消耗时长：|{}", end-start);
    }

    public static void main(String[] args) throws IOException {
//        jsonToSql("womanCheck.txt");
//        toSql();

        BigDecimal bigDecimal = new BigDecimal(2.89);
        double aa = 2.99;
//        bigDecimal = aa;
        System.out.println(bigDecimal);
    }
}
