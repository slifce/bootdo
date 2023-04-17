package com.bootdo.common.validator.rule;

import com.bootdo.common.validator.base.AbstractErrorMsgSignValidator;
import com.bootdo.common.validator.base.CommonValidatorHelper;
import com.bootdo.common.validator.base.DynamicObject;

public class IsExistsValidator extends AbstractErrorMsgSignValidator {
    @Override
    protected String realValidate(DynamicObject dynamicObject) {
        errorMsg = CommonValidatorHelper.getInstance().isExistsValidate(dynamicObject);
        return errorMsg;
    }
}
