package com.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description: 一句话描述功能;
 * @author: zxb
 * @date: 2018/12/12 14:09
 * @comment: 备注
 * @version: V1.0
 */
@Configuration
@EnableConfigurationProperties(JedisProperties.class)
@ConditionalOnClass(RedisClient.class)
public class JedisConfig {

    @Autowired
    private JedisProperties prop;

    @Bean(name = "jedisPool")
    public JedisPool jedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(prop.getMaxTotal());
        config.setMaxIdle(prop.getMaxIdle());
        config.setMaxWaitMillis(prop.getMaxWaitMillis());
        return new JedisPool(config, prop.getHost(), prop.getPort(), prop.getTimeOut(), prop.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean(RedisClient.class)
    public RedisClient redisClient(@Qualifier("jedisPool") JedisPool pool) {
        /*logger.info("初始化……Redis Client==Host={},Port={}",
                prop.getHost(), prop.getPort());*/
        RedisClient redisClient = new RedisClient();
        redisClient.setJedisPool(pool);
        return redisClient;
    }

}
