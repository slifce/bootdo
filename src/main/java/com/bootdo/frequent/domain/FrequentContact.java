package com.bootdo.frequent.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/18.
 */
public class FrequentContact implements Serializable{

    private Long id;

    private Long sysId;//用户id

    private String chineseName;//中文名

    private String englishName;//英文名

    private Integer sex;//性别

    private Integer identityType;//证件类别

    private String identityCode;//证件号码

    private Integer relationType;//关系类别

    private String mobilePhone;//手机号

    private String email;//邮箱

    private Long pcode;//省

    private Long ccode;//市

    private Long areacode;//区

    private String address;//地址

    private Integer isFrequent;//是否为常用联系人 0：是  1：否

    @JSONField(format="yyyy-MM-dd")
    private Date birthday;//生日

    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date addDate;//添加日期


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public Integer getRelationType() {
        return relationType;
    }

    public void setRelationType(Integer relationType) {
        this.relationType = relationType;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPcode() {
        return pcode;
    }

    public void setPcode(Long pcode) {
        this.pcode = pcode;
    }

    public Long getCcode() {
        return ccode;
    }

    public void setCcode(Long ccode) {
        this.ccode = ccode;
    }

    public Long getAreacode() {
        return areacode;
    }

    public void setAreacode(Long areacode) {
        this.areacode = areacode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsFrequent() {
        return isFrequent;
    }

    public void setIsFrequent(Integer isFrequent) {
        this.isFrequent = isFrequent;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}