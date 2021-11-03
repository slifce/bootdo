package com.bootdo.frequent.controller;

import com.bootdo.common.utils.ZMJsonUtil;
import com.bootdo.frequent.domain.FrequentContact;
import com.bootdo.frequent.service.FrequentContactService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by Administrator on 2018/10/18.
 */

@Controller
@RequestMapping("/frequent")
public class FrequentContactController {

    @Autowired
    private FrequentContactService frequentContactService;

    @ResponseBody
    @GetMapping("/list")
    //@RequiresPermissions("blog:bContent:bContent")
    public String list() {
        List<FrequentContact> frequentContactList = frequentContactService.selectAll();
        System.out.println(frequentContactList.size());
        System.out.println(213);
        return ZMJsonUtil.ZMObjectToJson(frequentContactList);
    }

    @ResponseBody
    @GetMapping("/query")
    public FrequentContact selectById() {
        FrequentContact frequentContact = frequentContactService.selectById(1L);
        System.out.println(frequentContact.getChineseName());
        return frequentContact;
    }

    @ResponseBody
    @GetMapping("/sayHello")
    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }

    @ResponseBody
    @GetMapping("/add")
    public String add() {
        FrequentContact frequentContact = frequentContactService.selectById(1L);
        if (Objects.isNull(frequentContact)) {
            return ZMJsonUtil.ZMObjectToJson(null, 401, "id为1的常用联系人不存在，请核对数据！");
        }
        frequentContact.setId(null);
        frequentContact.setAddDate(new Date());
        int save = frequentContactService.save(frequentContact);
        if (save > 0) {
            return ZMJsonUtil.ZMObjectToJson(frequentContact, 200, "数据添加成功！");
        }
        return ZMJsonUtil.ZMObjectToJson(frequentContact, 402, "数据添加失败！");
    }

    @ResponseBody
    @GetMapping("/addSysId")
    public String addSysId() {
        FrequentContact frequentContact = frequentContactService.selectById(1L);
        frequentContact.setSysId(frequentContact.getSysId() + 1);
        int result = frequentContactService.updateSysIdById(frequentContact);
        return ZMJsonUtil.ZMObjectToJson(result);
    }


    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @ResponseBody
    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/sendTopicMessage1")
    public String sendTopicMessage1() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: M A N ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/sendTopicMessage2")
    public String sendTopicMessage2() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: woman is all ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> womanMap = new HashMap<>();
        womanMap.put("messageId", messageId);
        womanMap.put("messageData", messageData);
        womanMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", womanMap);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/sendFanoutMessage")
    public String sendFanoutMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: testFanoutMessage ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        rabbitTemplate.convertAndSend("fanoutExchange", null, map);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/testMessageAck")
    public String testMessageAck() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: non-existent-exchange test message ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        rabbitTemplate.convertAndSend("non-existent-exchange", "TestDirectRouting", map);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/testMessageAck2")
    public String testMessageAck2() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: lonelyDirectExchange test message ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        rabbitTemplate.convertAndSend("lonelyDirectExchange", "TestDirectRouting", map);
        return "ok";
    }

}
