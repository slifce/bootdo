package com.bootdo.brave.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class TreeVo implements Serializable {
    @JSONField(ordinal = 1)
    private Integer id;

    @JSONField(ordinal = 2)
    private String name;

    @JSONField(ordinal = 3)
    private String number;

    @JSONField(ordinal = 4)
    private String parentNumber;

    @JSONField(ordinal = 5)
    private String level;

    @JSONField(ordinal = 6)
    private List<TreeVo> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getParentNumber() {
        return parentNumber;
    }

    public void setParentNumber(String parentNumber) {
        this.parentNumber = parentNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<TreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<TreeVo> children) {
        this.children = children;
    }
}