package com.bootdo.common.validator.base;

import com.bootdo.common.validator.rule.IsExistsValidator;
import com.bootdo.common.validator.rule.IsStartValidator;

public class ValidatorFactory {
    /**
     * 导入校验器holder
     *
     * @param dynamicObject 数据
     * @return 校验器holder
     */
    public static ValidatorHolder getImportValidatorHolder(DynamicObject dynamicObject) {
        // 校验全部
        ValidatorHolder holder = new ValidatorHolder(dynamicObject, true);
        // 原合同校验
        return getCommonValidatorHolder(holder);
    }

    /**
     * 手动新增校验器holder
     *
     * @param dynamicObject 数据
     * @return 校验器holder
     */
    public static ValidatorHolder getManualValidatorHolder(DynamicObject dynamicObject) {
        // 只抛出第一条不符合校验的提示
        ValidatorHolder holder = new ValidatorHolder(dynamicObject);
        // 原校验
        return getCommonValidatorHolder(holder);
    }

    private static ValidatorHolder getCommonValidatorHolder(ValidatorHolder holder) {
        // 是否已存在与审视名单校验
        holder.addValidator(new IsExistsValidator())
                // 是否已启动校验
                .addValidator(new IsStartValidator());
        return holder;
    }

}
