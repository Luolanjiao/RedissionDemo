package com.llj.redisapply;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplyApplication.class,
        properties = {
                "spring.redis.redisson.config=classpath:redisson.yaml",
                "spring.redis.timeout=10000"
        })
public class RedisApplyApplicationTests {

    @Autowired
    private RedissonClient redissonClient;
    @Test
    public void contextLoads() {
        System.out.println( redissonClient.getLock("myLock"));
    }
}
