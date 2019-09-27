package by.tms.spring.application.web_config;

import by.tms.spring.application.model.expression.Expression;
import by.tms.spring.application.model.user.User;
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
    public Map<String, List<Expression>> history() {
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
