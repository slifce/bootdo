package com.bootdo.common.validator.rule;

import com.bootdo.common.validator.base.AbstractErrorMsgSignValidator;
import com.bootdo.common.validator.base.CommonValidatorHelper;
import com.bootdo.common.validator.base.DynamicObject;

public class IsStartValidator extends AbstractErrorMsgSignValidator {
    @Override
    protected String realValidate(DynamicObject dynamicObject) {
        errorMsg = CommonValidatorHelper.getInstance().isStartValidate(dynamicObject);
        return errorMsg;
    }
}
