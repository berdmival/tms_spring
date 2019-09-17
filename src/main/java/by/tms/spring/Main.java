package by.tms.spring;

import by.tms.spring.calc.Calc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Calc calc = context.getBean("calc", Calc.class);
        System.out.println(calc.calculate());
    }
}
