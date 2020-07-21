package com.bootdo.brave.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/8/12.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(){
        return "hello world";
    }
}
