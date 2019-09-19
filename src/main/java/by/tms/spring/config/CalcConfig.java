package by.tms.spring.config;

import by.tms.spring.action.ActionType;
import by.tms.spring.util.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
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
    public ActionType getAction() {
        ActionType action;
        Scanner in = new Scanner(System.in);
        System.out.print("Input action (SUM, DIFF, MULT or DIV): ");
        String input = in.next().toUpperCase();
        if (Arrays.asList(ActionType.values()).stream().anyMatch(actionType -> actionType.toString().equals(input))) {
            action = ActionType.valueOf(input);
        } else {
            System.out.println("Please, input correct action (SUM, DIFF, MULT or DIV)!");
            action = getAction();
        }
        return action;
    }

}
