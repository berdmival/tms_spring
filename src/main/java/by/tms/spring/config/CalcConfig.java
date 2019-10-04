package by.tms.spring.config;

import by.tms.spring.model.ExpressionRecord;
import by.tms.spring.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "by.tms.spring")
public class CalcConfig {

    @Bean("users")
    public List<User> users() {
        return new ArrayList<>();
    }

    @Bean("history")
    public Map<Long, List<ExpressionRecord>> history() {
        return new HashMap<>();
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
