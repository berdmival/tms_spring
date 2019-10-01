package by.tms.spring.action;

public enum ActionTypeEnum {
    SUM("+"),
    DIFF("-"),
    MULT("*"),
    DIV("/");

    private String actCode;

    ActionTypeEnum(String s) {
        this.actCode = s;
    }

    public String getActCode(){
        return actCode;
    }
}
