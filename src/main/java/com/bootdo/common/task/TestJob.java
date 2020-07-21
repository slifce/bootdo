package com.bootdo.common.task;

import com.bootdo.oa.domain.Response;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * Created by Administrator on 2018/9/25.
 */
public class TestJob implements Job{
    @Autowired
    SimpMessagingTemplate template;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        template.convertAndSend("/topic/getResponse", new Response("测试计划任务！！！！！！！！！欢迎体验bootdo,欢迎您自主学习!" ));

    }
}
