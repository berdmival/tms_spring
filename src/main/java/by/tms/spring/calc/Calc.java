package by.tms.spring.calc;

import by.tms.spring.action.ActionType;
import by.tms.spring.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calc {
    private Double num1;
    private Double num2;
    private ActionType actionType;

    @Autowired
    public Calc(Double num1, Double num2, ActionType actionType) {
        this.num1 = num1;
        this.num2 = num2;
        this.actionType = actionType;
    }

    public Double calculate() {
        Double result;
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
                if (Validator.isValid(this.num1, this.num2, this.actionType)) {
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

    private Double sum(Double num1, Double num2) {
        return num1 + num2;
    }

    private Double diff(Double num1, Double num2) {
        return num1 - num2;
    }

    private Double mult(Double num1, Double num2) {
        return num1 * num2;
    }

    private Double div(Double num1, Double num2) {
        return num1 / num2;
    }
}
