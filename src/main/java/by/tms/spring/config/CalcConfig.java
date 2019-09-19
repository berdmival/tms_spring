package by.tms.spring.config;

import by.tms.spring.action.ActionTypeEnum;
import by.tms.spring.util.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class CalcConfig {

    private Double getNum(String msg) {
        Double result;
        Scanner in = new Scanner(System.in);
        System.out.print(msg);
        String inputData = in.nextLine();
        if (Validator.isNumeric(inputData)) {
            inputData = inputData.replaceAll(",", ".");
            result = Double.parseDouble(inputData);
        } else {
            System.out.println("Please, enter a correct number!");
            result = getNum(msg);
        }
        return result;
    }

    @Bean("num1")
    public Double getNum1() {
        return getNum("Input a number 1: ");
    }

    @Bean("num2")
    public Double getNum2() {
        return getNum("Input a number 2: ");
    }

    @Bean("action")
    public ActionTypeEnum getAction() {
        ActionTypeEnum action;
        String input;
        Scanner in = new Scanner(System.in);
        System.out.print("Input action (SUM, DIFF, MULT or DIV): ");
        input = in.next().toUpperCase();

        if (Validator.isValidAction(input)) {
            action = ActionTypeEnum.valueOf(input);
        } else {
            System.out.println("Please, input correct action (SUM, DIFF, MULT or DIV)!");
            action = getAction();
        }
        return action;
    }

}
