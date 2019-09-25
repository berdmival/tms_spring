package by.tms.spring.web_config;

import by.tms.spring.application.entity.User;
import by.tms.spring.application.expression.Expression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "by.tms.spring")
public class CalcConfig {

    @Bean("users")
    public List<User> users(){
        return new ArrayList<>();
    }

    @Bean("history")
    public List<Expression> history(){
        return new ArrayList<>();
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
