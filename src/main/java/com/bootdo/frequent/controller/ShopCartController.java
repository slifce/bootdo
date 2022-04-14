package com.bootdo.frequent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/shop")
public class ShopCartController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/submitOrder")
    @ResponseBody
    public String submitOrder() {
        // 超卖情况使用加锁
        synchronized (this) {
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                stock = stock - 1; // 更新库存
                stringRedisTemplate.opsForValue().set("stock", stock + "");
                System.out.println("扣减成功，库存stock:" + stock);
                Boolean setIfAbsent = stringRedisTemplate.opsForValue().setIfAbsent("stock", stock + "");
            } else {
                System.out.println("扣减失败，库存不足"); // 下单失败
                return "error";
            }
        }
        
        return "end";
    }
}
