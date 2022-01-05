package com.bootdo;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/9/30.
 */
public class FrenquentUtil {
    public static void main(String[] args) {
        System.out.println(123);
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("offset", 1);
        objectObjectHashMap.put("limit", 1);
        String msg = JSONObject.toJSONString(objectObjectHashMap);
        System.out.println(msg);
    }
}