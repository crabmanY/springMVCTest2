package com.smtest.main;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 测试连接redis
 *
 * @author crabman
 * @Date 2018-05-30 15:46
 */
public class RedisMain {
    public static void main(String [] args){
//        Jedis jedis=new Jedis("localhost",6379);
        //记录操作次数
        //使用连接池创建单个连接

        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        //最大的空闲数
        jedisPoolConfig.setMaxIdle(50);
        //最大连接数
        jedisPoolConfig.setMaxTotal(100);
        //设置最大等待的毫秒数
        jedisPoolConfig.setMaxWaitMillis(20000);
        //使用配置创建连接池
        JedisPool pool=new JedisPool(jedisPoolConfig,"localhost");
        //从连接池中获取单个连接
        Jedis jedis=pool.getResource();
        int i=0;
        try {
            long start=System.currentTimeMillis();
            while(true){
                long end=System.currentTimeMillis();
                if(end-start>=1000){
                    break;
                }
                i++;
                jedis.set("test"+i,i+"");
            }
        }finally {
            jedis.close();
        }
        System.out.println("redis每秒操作："+i+"次");

    }
}
