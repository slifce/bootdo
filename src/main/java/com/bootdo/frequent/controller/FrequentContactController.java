package com.bootdo.frequent.controller;

import com.bootdo.common.utils.ZMJsonUtil;
import com.bootdo.frequent.domain.FrequentContact;
import com.bootdo.frequent.service.FrequentContactService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public String list(){
        List<FrequentContact> frequentContactList = frequentContactService.selectAll();
        System.out.println(frequentContactList.size());
        System.out.println(213);
        return ZMJsonUtil.ZMObjectToJson(frequentContactList);
    }

    @ResponseBody
    @GetMapping("/query")
    public FrequentContact selectById(){
        FrequentContact frequentContact = frequentContactService.selectById(1L);
        System.out.println(frequentContact.getChineseName());
        return frequentContact;
    }

}
