package by.tms.spring.util;

import by.tms.spring.action.ActionType;

public class Validator {
    public static boolean isValidExpression(Double num1, Double num2, ActionType actionType) {
        boolean isValid = true;
        if (actionType.equals(ActionType.DIV) & num2 == 0) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        str = str.replaceAll(",", ".");
        int dotCount = 0;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                if (i == length - 1) {
                    return false;
                } else if (c == '.') {
                    if (++dotCount > 1) {
                        return false;
                    }
                } else if (i != 0 || c != '+' && c != '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
