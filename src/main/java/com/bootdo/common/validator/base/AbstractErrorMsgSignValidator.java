package com.bootdo.common.validator.base;

import com.bootdo.common.utils.StringUtils;

public abstract class AbstractErrorMsgSignValidator implements ValidatorBase {

    /**
     * 错误信息
     */
    protected String errorMsg = null;

    /**
     * 真正的校验方法，转换一下返回类型
     *
     * @param dynamicObject 申请单实体
     * @return 错误信息
     */
    protected abstract String realValidate(DynamicObject dynamicObject);

    /**
     * 校验，返回错误信息
     *
     * @param dynamicObject 申请实体
     * @return 错误信息
     */
    @Override
    public Object validate(DynamicObject dynamicObject) {
        return realValidate(dynamicObject);
    }

    /**
     * 是否继续校验
     *
     * @return true 继续后续校验
     * false 不再继续后续校验
     */
    @Override
    public boolean continueValidate() {
        return StringUtils.isEmpty(errorMsg);
    }

}
