package com.bootdo.common.validator.base;

public class CommonValidatorHelper {
    private static final CommonValidatorHelper COMMON_VALIDATOR_HELPER
            = new CommonValidatorHelper();

    private CommonValidatorHelper() {
    }

    /**
     * 获取实例
     *
     * @return 实例对象
     */
    public static CommonValidatorHelper getInstance() {
        return COMMON_VALIDATOR_HELPER;
    }

    /**
     * 是否存在审视名单校验
     *
     * @param dynamicObject 当前动态对象
     * @return 错误提示
     */
    public String isExistsValidate(DynamicObject dynamicObject) {
        // 执行业务逻辑
        return "存在审视名单校验";
    }

    /**
     * 是否启动校验
     *
     * @param dynamicObject 当前动态对象
     * @return 错误提示
     */
    public String isStartValidate(DynamicObject dynamicObject) {
        // 执行业务逻辑
        return "启动校验";
    }

}