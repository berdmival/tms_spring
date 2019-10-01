package by.tms.spring.service;

import by.tms.spring.action.ActionTypeEnum;
import by.tms.spring.model.ExpressionRecord;
import by.tms.spring.util.Validator;
import org.springframework.stereotype.Service;

@Service("calcService")
public class CalcService {

    public void calculate(ExpressionRecord expression) {
        ActionTypeEnum action = expression.getActionType();
        Number result;
        switch (action) {
            case SUM:
                result = sum(expression.getNum1(), expression.getNum2());
                break;

            case DIFF:
                result = diff(expression.getNum1(), expression.getNum2());
                break;

            case MULT:
                result = mult(expression.getNum1(), expression.getNum2());
                break;

            case DIV:
                if (Validator.isValidDIV(expression.getNum2(), action)) {
                    result = div(expression.getNum1(), expression.getNum2());
                } else {
                    result = null;
                }
                break;

            default:
                result = null;
        }

        expression.setResult(result);
    }

    private Number sum(Number num1, Number num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    private Number diff(Number num1, Number num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    private Number mult(Number num1, Number num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    private Number div(Number num1, Number num2) {
        return num1.doubleValue() / num2.doubleValue();
    }

}
