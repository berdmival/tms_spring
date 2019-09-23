package by.tms.spring.config;

import by.tms.spring.expression.CalcExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CalcConfig {

    @Bean("history")
    public List<CalcExpression> HistoryList() {
        return new ArrayList<>();
    }
}
