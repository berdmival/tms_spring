package by.tms.spring;

import by.tms.spring.action.ActionTypeEnum;
import by.tms.spring.expression.CalcExpression;
import by.tms.spring.expression.Expression;
import by.tms.spring.service.CalcService;
import by.tms.spring.service.DAOService;
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
    private static final String DATE_TIME_HISTORY_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String RESULT_IS_MSG = "Result is: ";
    private static final String HISTORY_OF_CALCULATING_MSG = "History of calculating: ";
    private static final String EXIT_MSG = "If you want to exit type 'q', else press ENTER";

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        CalcService calcService = context.getBean("calc", CalcService.class);
        DAOService DAO = context.getBean("dao", DAOService.class);

        try (Scanner in = new Scanner(System.in)) {
            while (!exitCalc(in)) {
                CalcExpression expression = context.getBean("historyItem", CalcExpression.class);

                getExpressionAttributesFromConsole(expression, in);

                calcService.calculate(expression);

                System.out.println(RESULT_IS_MSG + expression.getResult());

                addExpressionToHistory(expression, DAO);
            }
        }

        printHistory(DAO);
    }

    private static void printHistory(DAOService DAO) {
        List<Expression> history = DAO.getHistory();
        System.out.println(HISTORY_OF_CALCULATING_MSG);
        if (history.size() > 0) {
            for (Expression historyItem : history) {
                System.out.println(historyItem);
            }
        }
    }

    private static void addExpressionToHistory(CalcExpression expression, DAOService DAO) {
        expression.setDateTimeHistoryPattern(DATE_TIME_HISTORY_PATTERN);
        DAO.addToHistory(expression);
    }

    private static boolean exitCalc(Scanner in) {
        String inputData;
        System.out.print(EXIT_MSG);
        inputData = in.nextLine();
        return inputData.equals("q");
    }

    private static void getExpressionAttributesFromConsole(CalcExpression expression, Scanner in) {
        String inputData;
        inputData = getNumberFromConsole(in, INPUT_A_NUMBER_1_MSG);
        expression.setNum1(Double.parseDouble(inputData));

        inputData = getNumberFromConsole(in, INPUT_A_NUMBER_2_MSG);
        expression.setNum2(Double.parseDouble(inputData));

        inputData = getActionFromConsole(in);
        expression.setActionType(ActionTypeEnum.valueOf(inputData));
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
