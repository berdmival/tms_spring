package by.tms.spring.model;

import by.tms.spring.action.ActionTypeEnum;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ExpressionRecord implements Serializable {
    private static final long serialVersionUID = -1640716644237524349L;

    @Range(min = -9_223_372_036_854_775_808L, max = 9_223_372_036_854_775_807L)
    private Double num1;

    @Range(min = -9_223_372_036_854_775_808L, max = 9_223_372_036_854_775_807L)
    private Double num2;

    @NotNull
    private ActionTypeEnum actionType;
    private Number result;
    private LocalDateTime calcDateTime;

    public ExpressionRecord() {
        this.calcDateTime = LocalDateTime.now();
    }

    public Number getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public Number getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public ActionTypeEnum getActionType() {
        return actionType;
    }

    public void setActionType(ActionTypeEnum actionType) {
        this.actionType = actionType;
    }

    public Number getResult() {
        return result;
    }

    public void setResult(Number result) {
        this.result = result;
    }

    public LocalDateTime getCalcDateTime() {
        return calcDateTime;
    }
}
