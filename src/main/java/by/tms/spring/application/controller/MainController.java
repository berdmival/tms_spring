package by.tms.spring.application.controller;

import by.tms.spring.application.model.expression.ExpressionRecord;
import by.tms.spring.application.model.user.CalcUser;
import by.tms.spring.application.model.user.User;
import by.tms.spring.application.service.HistoryService;
import by.tms.spring.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/")
public class MainController {

    private final HistoryService historyService;
    private final UserService userService;

    @Autowired
    public MainController(@Qualifier("historyService") HistoryService historyService,
                          @Qualifier("userService") UserService userService) {
        this.historyService = historyService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");

        List<User> onlineUsers = userService.findOnlineUsers();
        modelAndView.addObject("onlineUsers", onlineUsers);

        Map<Integer, List<ExpressionRecord>> historyOnlineUsers = new HashMap<>();
        for (User u:
             onlineUsers) {
            CalcUser user = (CalcUser) u;
            historyOnlineUsers.put(user.getId(), historyService.getUserHistory(user.getId()));
        }
        modelAndView.addObject("historyOfOnlineUsers", historyOnlineUsers);

        return modelAndView;
    }
}
