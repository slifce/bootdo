package com.bootdo.common.validator.base;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ValidatorHolder {

    /**
     * 是否走完全部校验
     */
    private boolean validateAll;

    /**
     * 校验器集合，用于子类使用
     */
    private LinkedList<ValidatorBase> validators;

    /**
     * 申请实体
     */
    private DynamicObject signObj;

    public ValidatorHolder(DynamicObject signObj) {
        this.signObj = signObj;
        this.validateAll = false;
        validators = new LinkedList<>();
    }

    public ValidatorHolder(DynamicObject signObj, boolean validateAll) {
        this.signObj = signObj;
        this.validateAll = validateAll;
        validators = new LinkedList<>();
    }

    /**
     * 添加校验器
     *
     * @param validator 校验器
     * @return 当前对象
     */
    public ValidatorHolder addValidator(ValidatorBase validator) {
        validators.add(validator);
        return this;
    }

    /**
     * 移除校验器
     *
     * @param validator 校验器签证
     */
    public void removeValidator(ValidatorBase validator) {
        validators.remove(validator);
    }

    /**
     * 校验方法
     *
     * @return 校验结果
     */
    public Object startValidate() {
        return validateAll ? validateAll() : validateFirst();
    }

    /**
     * 开始校验，逐个开始校验
     * 如果不需要继续校验，则返回当前结果
     * 如果需要继续校验，则获取下一个校验器并继续校验
     *
     * @return 校验结果
     */
    private Object validateFirst() {
        for (ValidatorBase validator : validators) {
            Object validateResult = validator.validate(signObj);
            if (!validator.continueValidate()) {
                return validateResult;
            }
        }
        return null;
    }

    /**
     * 走完全部校验，获取校验结果
     *
     * @return 多条校验结果
     */
    private String validateAll() {
        StringBuffer errMsg = new StringBuffer();
        List<Object> allValidateError = getAllValidateError();
        allValidateError.forEach(validateResult -> {
            if (!StringUtils.isEmpty((String) validateResult)) {
                errMsg.append(validateResult);
                if (!String.class.cast(validateResult).endsWith(";")) {
                    errMsg.append(";");
                }
            }
        });
        return StringUtils.isEmpty(errMsg.toString()) ? null : errMsg.toString();
    }

    /**
     * 获取所有校验结果，不会因为单个校验器校验不通过而返回
     *
     * @return 错误信息集合，所有校验器的错误信息
     */
    private List<Object> getAllValidateError() {
        List<Object> errorList = new ArrayList<>(10);
        for (ValidatorBase validator : validators) {
            Object validateResult = validator.validate(signObj);
            if (!Objects.isNull(validateResult)) {
                errorList.add(validateResult);
            }
        }
        return errorList;
    }
}
