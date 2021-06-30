package com.pro.springboot.webservice;

import cn.hutool.db.nosql.redis.RedisDS;
import redis.clients.jedis.Jedis;

/**
 * @ClassName WebServiceUtils
 * @Description liguangyue
 * @Author 测试hutool调用webservice
 * @Date 2021/6/16 17:44
 * @Version 1.0
 **/
public class WebServiceUtils {

    public static void main(String[] args) {
        Jedis jedis = RedisDS.create().getJedis();
        jedis.setnx("","");
        jedis.get("");
        jedis.set("","");
    }
}
