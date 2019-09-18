package by.tms.spring;

import by.tms.spring.action.ActionType;
import by.tms.spring.calc.Calc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalcConfig {

    @Bean("num1")
    public Double getNum1() {
        return Double.parseDouble("15.7");
    }

    @Bean("num2")
    public Double getNum2() {
        return Double.parseDouble("17.8");
    }

    @Bean("calc")
    public Calc getCalc(Double num1, Double num2, @Value("SUM") ActionType actionType) {
        return new Calc(num1, num2, actionType);
    }
}
