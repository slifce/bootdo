package com.bootdo;

import com.bootdo.common.validator.base.DynamicObject;
import com.bootdo.common.validator.base.ValidatorFactory;
import com.bootdo.common.validator.base.ValidatorHolder;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class TestValidator {

    public static void main(String[] args) {
        DynamicObject dynamicObject = new DynamicObject();
        ImmutablePair<Boolean, String> booleanStringImmutablePairSingle = validatorSingle(dynamicObject);
        System.out.println(booleanStringImmutablePairSingle.getRight());
        ImmutablePair<Boolean, String> booleanStringImmutablePairAll = validatorAll(dynamicObject);
        System.out.println(booleanStringImmutablePairAll.getRight());
    }

    public static ImmutablePair<Boolean, String> validatorSingle(DynamicObject dynamicObject) {
        ImmutablePair<Boolean, String> result = ImmutablePair.of(Boolean.TRUE, null);
        // 错误信息，校验通过时为空
        String errorMsg;
        // 根据前置业务类型进行不同校验器的组合
        ValidatorHolder importValidatorHolder = ValidatorFactory.getManualValidatorHolder(dynamicObject);
        Object error = importValidatorHolder.startValidate();
        if (error != null) {
            errorMsg = String.class.cast(error);
            result = ImmutablePair.of(Boolean.FALSE, errorMsg);
        }
        return result;
    }

    public static ImmutablePair<Boolean, String> validatorAll(DynamicObject dynamicObject) {
        ImmutablePair<Boolean, String> result = ImmutablePair.of(Boolean.TRUE, null);
        // 错误信息，校验通过时为空
        String errorMsg;
        // 根据前置业务类型进行不同校验器的组合
        ValidatorHolder importValidatorHolder = ValidatorFactory.getImportValidatorHolder(new DynamicObject());
        Object error = importValidatorHolder.startValidate();
        if (error != null) {
            errorMsg = String.class.cast(error);
            result = ImmutablePair.of(Boolean.FALSE, errorMsg);
        }
        return result;
    }
}
