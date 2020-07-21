package com.bootdo.common.enumentity;

/**
 * Created by Administrator on 2018/10/18.
 */
public enum StatusEnum {
    SUCCESS(200,"操作成功！"), ERROR(500,"操作失败！"),NOTLOGIN(215,"没有登录"),
    NOTDATA(204,"暂未获取到数据"),DATAERROR(205,"数据异常"),ILLEGALO(216,"非法操作"),SESSIONEXPIRE(208,"会话过期")
    ,MISSCODE(301,"缺失关键参数！"),PARAMERROR(-1,"请求参数类型不匹配"),LOGINFO(00,"日志记录");

    private Integer code;
    private String message;

    private StatusEnum(int code,String message){
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public static String getMsgByCode(Integer code){
        for(StatusEnum entity : StatusEnum.values()){
            if(entity.getCode().equals(code)){
                return entity.getMessage();
            }
        }
        return "";
    }
}
