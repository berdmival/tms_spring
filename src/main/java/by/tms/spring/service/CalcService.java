package by.tms.spring.service;

import by.tms.spring.action.ActionTypeEnum;
import by.tms.spring.util.Validator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("calc")
public class CalcService {
    private Double num1;
    private Double num2;
    private ActionTypeEnum actionType;

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public void setActionType(ActionTypeEnum actionType) {
        this.actionType = actionType;
    }

    public void addCalculationToHistory (List history, Object historyItem) {
        history.add(historyItem);
    }

    public Number calculate() {
        Number result;
        switch (actionType) {
            case SUM:
                result = sum(this.num1, this.num2);
                break;

            case DIFF:
                result = diff(this.num1, this.num2);
                break;

            case MULT:
                result = mult(this.num1, this.num2);
                break;

            case DIV:
                if (Validator.isValidExpression(this.num1, this.num2, this.actionType)) {
                    result = div(this.num1, this.num2);
                } else {
                    result = null;
                }
                break;

            default:
                result = null;
        }

        return result;
    }

    private Number sum(Double num1, Double num2) {
        return num1 + num2;
    }

    private Number diff(Double num1, Double num2) {
        return num1 - num2;
    }

    private Number mult(Double num1, Double num2) {
        return num1 * num2;
    }

    private Number div(Double num1, Double num2) {
        return num1 / num2;
    }
}
