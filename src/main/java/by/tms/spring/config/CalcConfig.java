package by.tms.spring.config;

import by.tms.spring.action.ActionType;
import by.tms.spring.util.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class CalcConfig {

    @Bean("num1")
    public Double getNum1() {
        Double result;
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number 1: ");
        String inputData = in.nextLine();
        System.out.println();
        if (Validator.isNumeric(inputData)) {
            inputData = inputData.replaceAll(",", ".");
            result = Double.parseDouble(inputData);
        } else {
            System.out.println("Please, enter a number");
            result = getNum1();
        }
        return result;
    }

    @Bean("num2")
    public Double getNum2() {
        Double result;
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number 2: ");
        String inputData = in.nextLine();
        System.out.println();
        if (Validator.isNumeric(inputData)) {
            inputData = inputData.replaceAll(",", ".");
            result = Double.parseDouble(inputData);
        } else {
            System.out.println("Please, enter a number");
            result = getNum2();
        }
        return result;
    }

    @Bean("action")
    public ActionType getAction() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input action (SUM, DIFF, MULT or DIV): ");
        ActionType num = ActionType.valueOf(in.next().toUpperCase());
        System.out.println();
        return num;
    }

}
