package by.tms.spring.expression;

import by.tms.spring.action.ActionTypeEnum;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component("historyItem")
@Scope("prototype")
@Lazy()
public class CalcExpression implements Expression {
    private Number num1;
    private Number num2;
    private ActionTypeEnum actionType;
    private Number result;
    private LocalDateTime calcDateTime;
    private String dateTimeHistoryPattern;

    public CalcExpression() {
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
