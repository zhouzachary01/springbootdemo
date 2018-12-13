package com.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @description: 一句话描述功能;
 * @author: zxb
 * @date: 2018/12/12 14:14
 * @comment: 备注
 * @version: V1.0
 */
public class RedisClient {

    private JedisPool jedisPool;

    public void set(String key, Object value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close(); }
    }

    public void setWithExpireTime(String key, String value, int exptime) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value, "NX", "EX", exptime);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
    }

    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null) jedis.close();
        } return null;
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }
    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }


}
