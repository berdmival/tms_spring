package by.tms.spring.service;

import by.tms.spring.action.ActionTypeEnum;
import by.tms.spring.model.ExpressionRecord;
import org.springframework.stereotype.Service;

@Service("expressionRecordService")
public class CalcExpressionRecordService {

    public ExpressionRecord createExpressionRecord(Double num1, Double num2, ActionTypeEnum action) {
        ExpressionRecord expression = new ExpressionRecord();
        expression.setNum1(num1);
        expression.setNum2(num2);
        expression.setActionType(action);
        return expression;
    }
}
