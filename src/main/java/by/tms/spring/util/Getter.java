package by.tms.spring.util;

import java.util.Scanner;

public class Getter {
    public static Double getNum(String msg) {
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
}
