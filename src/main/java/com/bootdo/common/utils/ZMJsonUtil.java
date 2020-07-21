package com.bootdo.common.utils;

import java.io.IOException;
import com.alibaba.fastjson.JSON;
import com.bootdo.common.enumentity.StatusEnum;

/**
 * Created by Administrator on 2018/10/18.
 */


public class ZMJsonUtil extends JSON{

    /**
     * 自动转换成obj
     * @param obj
     * @param code 状态码
     * @param msg 状态码描述
     * @return  附有状态码，状态信息
     */
    public static<T> String ZMObjectToJson(T obj,int code,String msg){
        String str="";
        StaticEntity<T> entity=ZMJsonUtil.ZMObjectToEntity(obj,code,msg);
        str=ZMJsonUtil.ZMStaticEntityToJson(entity);
        return str;
    }

    /**
     * 请求已接收，参数类型错误，无匹配数据
     * @return json字符串
     * @author: qiuxiaoxing
     */
    public static String requestParameterTypeError(){
        return ZMJsonUtil.ZMObjectToJson(null,StatusEnum.PARAMERROR.getCode(),StatusEnum.PARAMERROR.getMessage());
    }

    public static<T> String Fail(@SuppressWarnings("unchecked") T... param){
        return ZMObjectToJson(param, StatusEnum.ERROR.getCode(),StatusEnum.ERROR.getMessage());
    }

    /**
     * 自动转换成obj
     * @param obj
     * @param code 状态码
     * @param msg 状态码描述
     * @return  附有状态码，状态信息
     */
    public static<T> StaticEntity<T> ZMObjectToEntity(T obj,int code,String msg){

        StaticEntity<T> entity=new StaticEntity<T>();
        entity.setCode(code);
        entity.setMessage(msg);
        entity.setData(obj);
        return entity;
    }
    /**
     *  staticEntity 转换成 json 格式字符串
     * @param entity
     * @return  json 格式字符串
     */
    public static<T>  String ZMStaticEntityToJson(StaticEntity<T> entity){

        try {
            return JSONUtils.ObjectToJson(entity);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "HXConstant.ERROR_CHANGE";
        }

    }

    /**
     * object转换成json字符串 ，默认操作成功
     * @param obj
     * @return json字符串
     */
    public static<T> String ZMObjectToJson(T obj){
        String str=ZMObjectToJson(obj,StatusEnum.SUCCESS.getCode(),StatusEnum.SUCCESS.getMessage());
        return str;
    }
    /**
     * 返回操作失败
     * @return json字符串
     */
    public static String Fail(){
        return ZMObjectToJson("",StatusEnum.ERROR.getCode(),StatusEnum.ERROR.getMessage());
    }
    /**
     * 返回操作失败
     * @return staticEntity 类型
     */
    public static  StaticEntity<String> FailToEntity(){
        return  ZMJsonUtil.ZMObjectToEntity("",StatusEnum.ERROR.getCode(),StatusEnum.ERROR.getMessage());
    }


    /**
     * 返回自定义操作失败信息
     * @param code  错误码
     * @param message  错误信息
     * @return
     */
    public static String Fail(Integer code,String message){
        return ZMObjectToJson("",StatusEnum.ERROR.getCode(),StatusEnum.ERROR.getMessage());
    }



    public static<T> T ZMJsonToObject(String str,Class<T> clzz){
        T object=(T) JSONUtils.JSONToObj(str, clzz);
        return object;
    }
    /**
     *
     * @Title: ZMParameterMiss
     * @Description: 接口缺失关键参数
     * @param :	obj
     * @return: String
     * @author: liwenhui
     * @date :2017年7月6日
     */
    public static<T> String ZMParameterMiss(T obj){
        String str = ZMObjectToJson(obj , StatusEnum.MISSCODE.getCode(),StatusEnum.MISSCODE.MISSCODE.getMessage());
        return str;
    }


    /**
     *
     *
     * @Title: userNotLogin
     * @Description: 用户未登录
     * @param :
     * @return: String
     * @author: liwenhui
     * @date :2018年2月1日上午10:15:33
     */
    public static String NotLogin(){
        String str = ZMObjectToJson("",StatusEnum.NOTLOGIN.getCode(),StatusEnum.NOTLOGIN.getMessage());
        return str;
    }

    /**
     *
     * @Title: getNoData
     * @Description: 接口未获取到数据
     * @param :
     * @return: String
     * @author: liwenhui
     * @date :2017年7月6日
     */
    public static String getNoData(){
        String str = ZMObjectToJson("",StatusEnum.NOTDATA.getCode(),StatusEnum.NOTDATA.getMessage());
        return str;
    }

    public static String getNoData(Object obj){
        String str = ZMObjectToJson(obj,StatusEnum.NOTDATA.getCode(),StatusEnum.NOTDATA.getMessage());
        return str;
    }

    /**
     *
     * @Title: dataError
     * @Description: 数据异常
     * @param :
     * @return: String
     * @author: liwenhui
     * @date :2017年7月6日
     */
    public static String dataError(){
        String str = ZMObjectToJson("",StatusEnum.DATAERROR.getCode(),StatusEnum.DATAERROR.getMessage());
        return str;
    }

    /**
     * 请求已接收，参数类型错误，无匹配数据
     * @return json字符串
     * @author: qiuxiaoxing
     */
    public static String requestParameterTypeError(String str){
        return ZMJsonUtil.ZMObjectToJson(str,StatusEnum.PARAMERROR.getCode(),StatusEnum.PARAMERROR.getMessage());
    }

    public static<T> String LogInfo(@SuppressWarnings("unchecked") T... param){
        return ZMObjectToJson(param,StatusEnum.LOGINFO.getCode(),StatusEnum.LOGINFO.getMessage());
    }

}

