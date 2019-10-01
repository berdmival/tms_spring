package by.tms.spring.controller;

import by.tms.spring.model.User;
import by.tms.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/logout")
public class LogoutController {

    private final UserService userService;

    public LogoutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String logout(HttpSession session) {
        userService.logout(((User) session.getAttribute("user")).getId());
        session.invalidate();
        return "index";
    }
}
