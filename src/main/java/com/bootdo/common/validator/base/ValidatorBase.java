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

    abstract class AbstractErrorMsgSignValidator implements ValidatorBase {
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
        public String validate(DynamicObject dynamicObject) {
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
}
