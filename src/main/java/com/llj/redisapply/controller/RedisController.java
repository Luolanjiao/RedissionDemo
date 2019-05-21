package com.llj.redisapply.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lanjiao.luo
 * @date 2019/5/16 13:33
 **/
@RestController
public class RedisController {
    @Autowired
    private RedissonClient redissonClient;

    private int count=0;

    @RequestMapping("/test")
    public String test(){
      RLock rLock= redissonClient.getLock("myLock");
        try {
            boolean isLock= rLock.tryLock(20,2, TimeUnit.SECONDS);
            if(isLock){
                long time=System.currentTimeMillis();
                System.out.println("获得锁"+rLock.getName());
                count++;
                Thread.sleep(5*1000);
                System.out.println("加一次后 "+count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
