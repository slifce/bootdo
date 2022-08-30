package com.bootdo;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by Administrator on 2018/9/30.
 */
public class FrequentUtil {
    public static void main(String[] args) {
        System.out.println(123);
        String msg = getMsg();

        System.out.println(msg);

        List<Object> list2 = new ArrayList<>();
        Assert.assertTrue("999", CollectionUtils.isEmpty(list2));

        ReadWriteLock readWriteLock = new ReadWriteLock() {
            @Override
            public Lock readLock() {
                return null;
            }

            @Override
            public Lock writeLock() {
                return null;
            }
        };


        readWriteLock.readLock().lock();
        try {
            List<Object> list = new ArrayList<>();
            Assert.assertTrue("999", CollectionUtils.isEmpty(list));
            Assert.assertTrue("123", Objects.isNull(list));
            Assert.assertTrue("123", Objects.isNull(list));
            Date date = new Date();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    private static String getMsg() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("offset", 1);
        objectObjectHashMap.put("limit", 1);
        String msg = JSONObject.toJSONString(objectObjectHashMap);
        return msg;
    }
}