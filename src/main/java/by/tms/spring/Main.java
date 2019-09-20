package by.tms.spring;

import by.tms.spring.action.ActionTypeEnum;
import by.tms.spring.service.CalcService;
import by.tms.spring.util.Validator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Scanner;

@ComponentScan("by.tms.spring")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        CalcService calcService = context.getBean("calc", CalcService.class);
        List history = context.getBean("history", List.class);
        Scanner in = new Scanner(System.in);

        while (true) {
            String inputData;
            StringBuilder historyItemBuilder = new StringBuilder();

            System.out.print("If you want to exit type 'q', else type 'y'");
            inputData = in.nextLine();
            if (inputData.equals("q")) {
                break;
            }

            inputData = getNumberFromConsole(in, "Input a number 1: ");
            historyItemBuilder.append("Num1: ").append(inputData);
            calcService.setNum1(Double.parseDouble(inputData));

            inputData = getNumberFromConsole(in, "Input a number 2: ");
            historyItemBuilder.append(", num2: ").append(inputData);
            calcService.setNum2(Double.parseDouble(inputData));

            inputData = getActionFromConsole(in, "Input action (SUM, DIFF, MULT or DIV): ");
            historyItemBuilder.append(", action: ").append(inputData);
            calcService.setActionType(ActionTypeEnum.valueOf(inputData));

            System.out.println("Result is: " + calcService.calculate());
            historyItemBuilder.append(", result: ").append(calcService.calculate());

            calcService.addCalculationToHistory(history, historyItemBuilder.toString());
        }
        in.close();

        System.out.println("History of calculating: ");
        if (history.size() > 0) {
            for (Object historyItem : history) {
                System.out.println(historyItem);
            }
        }
    }

    private static String getActionFromConsole(Scanner in, String s) {
        String inputData;
        do {
            System.out.print(s);
            inputData = in.nextLine().toUpperCase();
        }
        while (!Validator.isValidAction(inputData));
        return inputData;
    }

    private static String getNumberFromConsole(Scanner in, String s) {
        String inputData;
        do {
            System.out.print(s);
            inputData = in.nextLine();
        }
        while (!Validator.isNumeric(inputData));
        inputData = inputData.replaceAll(",", ".");
        return inputData;
    }
}
