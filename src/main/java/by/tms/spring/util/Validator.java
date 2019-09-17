package by.tms.spring.util;

import by.tms.spring.action.ActionType;

public class Validator {
    public static boolean isValid(Double num1, Double num2, ActionType actionType) {
        boolean isValid = true;
        if (actionType.equals(ActionType.DIV) & num2 == 0) {
            isValid = false;
        }
        return isValid;
    }
}
