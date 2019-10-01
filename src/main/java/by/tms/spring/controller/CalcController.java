package by.tms.spring.controller;

import by.tms.spring.action.ActionTypeEnum;
import by.tms.spring.model.ExpressionRecord;
import by.tms.spring.model.User;
import by.tms.spring.service.CalcService;
import by.tms.spring.service.HistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/calc")
@SessionAttributes("user")
public class CalcController {

    private final HistoryService historyService;
    private final CalcService calcService;

    public CalcController(HistoryService historyService,
                          CalcService calcService) {
        this.historyService = historyService;
        this.calcService = calcService;
    }

    @GetMapping
    public ModelAndView calcShow(ModelAndView modelAndView,
                                 @ModelAttribute("user") User user
    ) {

        modelAndView.setViewName("calc");

        int userId = user.getId();

        if (historyService.getUserHistory(userId) == null) {
            historyService.createHistoryForUser(userId);
        }

        modelAndView.addObject("history", historyService.getUserHistory(userId));
        modelAndView.addObject("expression", new ExpressionRecord());
        modelAndView.addObject("possibleActions", ActionTypeEnum.values());

        return modelAndView;
    }

    @PostMapping
    public ModelAndView calcExpr(ModelAndView modelAndView,
                                 @ModelAttribute("user") User user,
                                 @ModelAttribute("expression") ExpressionRecord expression) {

        int userId = user.getId();

        calcService.calculate(expression);

        historyService.addRecordForUsersHistory(userId, expression);

        modelAndView.addObject("message", expression.getResult());
        modelAndView.addObject("history", historyService.getUserHistory(userId));
        modelAndView.addObject("possibleActions", ActionTypeEnum.values());

        modelAndView.setViewName("calc");
        return modelAndView;
    }
}
