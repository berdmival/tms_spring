package by.tms.spring.application.util;

import by.tms.spring.application.action.ActionTypeEnum;
import by.tms.spring.application.model.expression.CalcExpression;


public class Calculator {

    public static void calculate(CalcExpression expression) {
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

    private static Number sum(Number num1, Number num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    private static Number diff(Number num1, Number num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    private static Number mult(Number num1, Number num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    private static Number div(Number num1, Number num2) {
        return num1.doubleValue() / num2.doubleValue();
    }

}
