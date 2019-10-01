package by.tms.spring.controller;

import by.tms.spring.action.ActionTypeEnum;
import by.tms.spring.model.ExpressionRecord;
import by.tms.spring.model.User;
import by.tms.spring.service.CalcExpressionRecordService;
import by.tms.spring.service.CalcService;
import by.tms.spring.service.HistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/calc")
public class CalcController {

    private final HistoryService historyService;
    private final CalcService calcService;
    private final CalcExpressionRecordService calcExpressionRecordService;

    public CalcController(HistoryService historyService,
                          CalcService calcService,
                          CalcExpressionRecordService calcExpressionRecordService) {
        this.historyService = historyService;
        this.calcService = calcService;
        this.calcExpressionRecordService = calcExpressionRecordService;
    }

    @GetMapping
    public ModelAndView calcShow(ModelAndView modelAndView, HttpSession session) {

        modelAndView.setViewName("calc");

        int userId = ((User) session.getAttribute("user")).getId();

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
                                 HttpSession session,
                                 @ModelAttribute("expression") ExpressionRecord expression) {

        int userId = ((User) session.getAttribute("user")).getId();

        calcService.calculate(expression);

        historyService.addRecordForUsersHistory(userId, expression);

        modelAndView.addObject("message", expression.getResult());
        modelAndView.addObject("history", historyService.getUserHistory(userId));
        modelAndView.addObject("possibleActions", ActionTypeEnum.values());

        modelAndView.setViewName("calc");
        return modelAndView;
    }
}
