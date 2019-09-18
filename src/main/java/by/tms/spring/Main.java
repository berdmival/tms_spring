package by.tms.spring;

import by.tms.spring.calc.Calc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CalcConfig.class);
        Calc calc = context.getBean("calc", Calc.class);
        System.out.println(calc.calculate());
    }
}
