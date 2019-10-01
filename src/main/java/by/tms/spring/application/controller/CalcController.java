package by.tms.spring.application.controller;

import by.tms.spring.application.action.ActionTypeEnum;
import by.tms.spring.application.model.expression.CalcExpressionRecord;
import by.tms.spring.application.model.user.CalcUser;
import by.tms.spring.application.service.CalcExpressionRecordService;
import by.tms.spring.application.service.CalcService;
import by.tms.spring.application.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/calc")
public class CalcController {

    private final HistoryService historyService;
    private final CalcService calcService;
    private final CalcExpressionRecordService calcExpressionRecordService;

    @Autowired
    public CalcController(@Qualifier("historyService") HistoryService historyService,
                          @Qualifier("calcService") CalcService calcService,
                          @Qualifier("expressionRecordService") CalcExpressionRecordService calcExpressionRecordService) {
        this.historyService = historyService;
        this.calcService = calcService;
        this.calcExpressionRecordService = calcExpressionRecordService;
    }

    @GetMapping
    public ModelAndView calcShow(ModelAndView modelAndView, HttpSession session) {

        modelAndView.setViewName("calc");

        int userId = ((CalcUser) session.getAttribute("user")).getId();

        if (historyService.getUserHistory(userId) == null) {
            historyService.createHistoryForUser(userId);
        }

        modelAndView.addObject("history", historyService.getUserHistory(userId));

        return modelAndView;
    }

    @PostMapping
    public ModelAndView calcExpr(ModelAndView modelAndView,
                              HttpSession session,
                              @RequestParam(name = "num1") double num1,
                              @RequestParam(name = "num2") double num2,
                              @RequestParam(name = "action") String action) {

        int userId = ((CalcUser) session.getAttribute("user")).getId();

        CalcExpressionRecord expression = calcExpressionRecordService.createExpressionRecord(
                num1,
                num2,
                ActionTypeEnum.valueOf(action.toUpperCase()));

        calcService.calculate(expression);

        historyService.addRecordForUsersHistory(userId, expression);

        modelAndView.addObject("message", expression.getResult());
        modelAndView.addObject("history", historyService.getUserHistory(userId));

        modelAndView.setViewName("calc");
        return modelAndView;
    }
}
