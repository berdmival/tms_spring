package by.tms.spring;

import by.tms.spring.calc.CalcService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        CalcService calcService = context.getBean("calc", CalcService.class);
        System.out.println("Result is: " + calcService.calculate());
    }
}
