package com.llj.redisapply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class RedisApplyApplication {

    public static void main(String[] args) {

        SpringApplication.run(RedisApplyApplication.class, args);
    }

}
