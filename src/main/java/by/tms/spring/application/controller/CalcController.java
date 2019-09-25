package by.tms.spring.application.controller;

import by.tms.spring.application.action.ActionTypeEnum;
import by.tms.spring.application.expression.CalcExpression;
import by.tms.spring.application.expression.Expression;
import by.tms.spring.application.repository.HistoryRepository;
import by.tms.spring.application.util.Calculator;
import by.tms.spring.application.util.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(path = "/calc")
public class CalcController {

    private static final String CHECK_YOUR_INPUT_PLEASE_MESSAGE = "Check your input, please!";

    @Resource(name = "historyRepository")
    HistoryRepository repository;

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("calc");
        modelAndView.addObject("name", "Guest");
        modelAndView.addObject("history", repository.getHistory());
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

            repository.addToHistory(expression);
            modelAndView.addObject("message", expression.getResult());
        } else {
            modelAndView.addObject("message", CHECK_YOUR_INPUT_PLEASE_MESSAGE);
        }

        List<Expression> history = repository.getHistory();

        modelAndView.setViewName("calc");
        modelAndView.addObject("history", history);
        return modelAndView;
    }
}
