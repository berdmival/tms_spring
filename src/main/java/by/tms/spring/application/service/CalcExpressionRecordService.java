package by.tms.spring.application.service;

import by.tms.spring.application.action.ActionTypeEnum;
import by.tms.spring.application.model.expression.CalcExpressionRecord;
import org.springframework.stereotype.Service;

@Service("expressionRecordService")
public class CalcExpressionRecordService {

    public CalcExpressionRecord createExpressionRecord(Number num1, Number num2, ActionTypeEnum action) {
        CalcExpressionRecord expression = new CalcExpressionRecord();
        expression.setNum1(num1);
        expression.setNum2(num2);
        expression.setActionType(action);
        return expression;
    }
}
