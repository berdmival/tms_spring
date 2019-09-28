package by.tms.spring.application.model.expression;

import by.tms.spring.application.action.ActionTypeEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CalcExpressionRecord implements ExpressionRecord {
    private Number num1;
    private Number num2;
    private ActionTypeEnum actionType;
    private Number result;
    private LocalDateTime calcDateTime;
    private String dateTimeHistoryPattern;

    public CalcExpressionRecord() {
        this.calcDateTime = LocalDateTime.now();
    }

    public void setNum1(Number num1) {
        this.num1 = num1;
    }

    public void setNum2(Number num2) {
        this.num2 = num2;
    }

    public void setActionType(ActionTypeEnum actionType) {
        this.actionType = actionType;
    }

    public void setResult(Number result) {
        this.result = result;
    }

    public void setDateTimeHistoryPattern(String dateTimeHistoryPattern) {
        this.dateTimeHistoryPattern = dateTimeHistoryPattern;
    }

    public Number getNum1() {
        return num1;
    }

    public Number getNum2() {
        return num2;
    }

    public ActionTypeEnum getActionType() {
        return actionType;
    }

    public Number getResult() {
        return result;
    }

    public LocalDateTime getCalcDateTime() {
        return calcDateTime;
    }

    @Override
    public String toString() {
        return "CalcExpression{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", actionType=" + actionType +
                ", result=" + result +
                ", calcDateTime='" + calcDateTime.format(DateTimeFormatter.ofPattern(dateTimeHistoryPattern)) + '\'' +
                '}';
    }
}
