package by.tms.spring;

import by.tms.spring.action.ActionTypeEnum;
import by.tms.spring.service.CalcService;
import by.tms.spring.util.Validator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Scanner;

@ComponentScan
public class Main {

    private static final String INPUT_A_NUMBER_1_MSG = "Input a number 1: ";
    private static final String INPUT_A_NUMBER_2_MSG = "Input a number 2: ";
    private static final String INPUT_ACTION_MSG = "Input action (SUM, DIFF, MULT or DIV): ";

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        CalcService calcService = context.getBean("calc", CalcService.class);
        List history = context.getBean("history", List.class);
        Scanner in = new Scanner(System.in);

        while (true) {
            StringBuilder historyItemBuilder = new StringBuilder();

            if (exitOrContinue(in)) break;

            getCalcServiceAttributesFromConsole(calcService, in, historyItemBuilder);

            calcService.addCalculationToHistory(history, historyItemBuilder.toString());

            System.out.println("Result is: " + calcService.calculate());
        }

        in.close();

        System.out.println("History of calculating: ");
        if (history.size() > 0) {
            for (Object historyItem : history) {
                System.out.println(historyItem);
            }
        }
    }

    private static boolean exitOrContinue(Scanner in) {
        String inputData;
        System.out.print("If you want to exit type 'q', else type 'y'");
        inputData = in.nextLine();
        return inputData.equals("q");
    }

    private static void getCalcServiceAttributesFromConsole(CalcService calcService, Scanner in, StringBuilder historyItemBuilder) {
        String inputData;
        inputData = getNumberFromConsole(in, INPUT_A_NUMBER_1_MSG);
        historyItemBuilder.append("Num1: ").append(inputData);
        calcService.setNum1(Double.parseDouble(inputData));

        inputData = getNumberFromConsole(in, INPUT_A_NUMBER_2_MSG);
        historyItemBuilder.append(", num2: ").append(inputData);
        calcService.setNum2(Double.parseDouble(inputData));

        inputData = getActionFromConsole(in);
        historyItemBuilder.append(", action: ").append(inputData);
        calcService.setActionType(ActionTypeEnum.valueOf(inputData));

        historyItemBuilder.append(", result: ").append(calcService.calculate());
    }

    private static String getActionFromConsole(Scanner in) {
        String inputData;
        do {
            System.out.print(Main.INPUT_ACTION_MSG);
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
