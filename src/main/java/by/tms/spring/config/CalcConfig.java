package by.tms.spring.config;

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

}
