package by.tms.spring.expression;

import by.tms.spring.action.ActionTypeEnum;

public interface Expression {
    void setNum1(Number num1);

    void setNum2(Number num2);

    void setActionType(ActionTypeEnum actionType);

    void setResult(Number calculate);

    void setDateTimeHistoryPattern(String dateTimeHistoryPattern);
}
