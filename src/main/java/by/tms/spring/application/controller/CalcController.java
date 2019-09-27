package by.tms.spring.application.controller;

import by.tms.spring.application.action.ActionTypeEnum;
import by.tms.spring.application.model.expression.CalcExpression;
import by.tms.spring.application.util.Calculator;
import by.tms.spring.application.util.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/calc")
public class CalcController {

    private static final String CHECK_YOUR_INPUT_PLEASE_MESSAGE = "Check your input, please!";

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("calc");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView index(ModelAndView modelAndView,
                              @RequestParam(name = "num1") String num1,
                              @RequestParam(name = "num2") String num2,
                              @RequestParam(name = "action") String action) {

        if (Validator.isNumeric(num1) & Validator.isNumeric(num2) & Validator.isValidAction(action.toUpperCase())) {
            CalcExpression expression = new CalcExpression();
            expression.setNum1(Double.parseDouble(num1));
            expression.setNum2(Double.parseDouble(num2));
            expression.setActionType(ActionTypeEnum.valueOf(action.toUpperCase()));
            Calculator.calculate(expression);

            modelAndView.addObject("message", expression.getResult());
        } else {
            modelAndView.addObject("message", CHECK_YOUR_INPUT_PLEASE_MESSAGE);
        }

        modelAndView.setViewName("calc");
        return modelAndView;
    }
}
