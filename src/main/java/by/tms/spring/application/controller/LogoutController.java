package by.tms.spring.application.controller;

import by.tms.spring.application.model.user.CalcUser;
import by.tms.spring.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/logout")
public class LogoutController {

    private final UserService userService;

    @Autowired
    public LogoutController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String logout(HttpSession session) {
        userService.logout(((CalcUser) session.getAttribute("user")).getId());
        session.invalidate();
        return "index";
    }
}
