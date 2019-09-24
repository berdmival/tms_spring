package by.tms.spring.application.util;

import by.tms.spring.application.action.ActionTypeEnum;

public class Validator {

    public static boolean isValidAction(String input) {
        for (ActionTypeEnum actionType : ActionTypeEnum.values()) {
            if (actionType.toString().equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidDIV(Number num2, ActionTypeEnum actionTypeEnum) {
        return !(actionTypeEnum.equals(ActionTypeEnum.DIV) & num2.doubleValue() == 0);
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
