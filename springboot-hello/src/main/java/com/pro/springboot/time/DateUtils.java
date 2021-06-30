package com.pro.springboot.time;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description 日期工具类
 * @Author liguangyue
 * @Date 2021/3/29 11:19
 * @Version 1.0
 **/
public class DateUtils {

    public static String getDate(int i) // //获取前后日期 i为正数 向后推迟i天，负数时向前提前i天
    {
        Calendar cd = Calendar.getInstance();
        cd.add(Calendar.DATE, i);
        Date dat = cd.getTime();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd ");
        return sd.format(dat);
    }

    public static int getAgeByBirth(String birthday, String depatureTime) throws ParseException {
        // 格式化传入的时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = format.parse(birthday);
        Date utilDate = format.parse(depatureTime);
        int age = 0;
        try {
            Date date = new java.sql.Date(utilDate.getTime());
            Calendar now = Calendar.getInstance();
            now.setTime(date); // 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(parse); // 传入的时间

            //如果传入的时间，在当前时间的后面，返回0岁
            if (birth.after(now)) {
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                } else if (now.get(Calendar.DAY_OF_YEAR) == birth.get(Calendar.DAY_OF_YEAR)) {
                    if (now.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
                        age += 1;
                    }
                }
            }
            return age;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) throws ParseException {
//        System.out.println(getDate(-14));
//        System.out.println(getAgeByBirth("1948-06-19 01:00:00.0","2021-06-09 15:16:01.0"));
        System.out.println(getDate(13));
    }
}
