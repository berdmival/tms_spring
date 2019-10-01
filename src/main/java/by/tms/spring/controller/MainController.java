package by.tms.spring.controller;

import by.tms.spring.model.ExpressionRecord;
import by.tms.spring.model.User;
import by.tms.spring.service.HistoryService;
import by.tms.spring.service.UserService;
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

    public MainController(HistoryService historyService,
                          UserService userService) {
        this.historyService = historyService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");

        List<User> onlineUsers = userService.findOnlineUsers();
        modelAndView.addObject("onlineUsers", onlineUsers);

        Map<Integer, List<ExpressionRecord>> historyOnlineUsers = new HashMap<>();
        for (User u :
                onlineUsers) {
            User user = u;
            historyOnlineUsers.put(user.getId(), historyService.getUserHistory(user.getId()));
        }
        modelAndView.addObject("historyOfOnlineUsers", historyOnlineUsers);

        return modelAndView;
    }
}
