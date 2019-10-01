package by.tms.spring.controller;

import by.tms.spring.model.User;
import by.tms.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(path = "/logout")
@SessionAttributes("user")
public class LogoutController {

    private final UserService userService;

    public LogoutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String logout(SessionStatus status,
                         @ModelAttribute("user") User user
    ) {
        userService.logout(user.getId());
        status.setComplete();
        return "redirect:/";
    }
}
