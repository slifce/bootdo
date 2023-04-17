package com.bootdo.common.validator.base;

import org.apache.commons.lang3.StringUtils;

/**
 * 通用校验器接口
 *
 * @since 2020/11/27
 */
public interface ValidatorBase {
    /**
     * 校验，返回错误信息
     *
     * @param dynamicObject 动态对象
     * @return 错误信息
     */
    String validate(DynamicObject dynamicObject);

    /**
     * 是否继续校验
     *
     * @return true 继续后续校验
     * false 不再继续后续校验
     */
    boolean continueValidate();
}
