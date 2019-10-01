package by.tms.spring.controller;

import by.tms.spring.model.AuthData;
import by.tms.spring.model.User;
import by.tms.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/auth")
@SessionAttributes("user")
public class AuthController {

    private static final String INCORRECT = "Authenticate failed!";

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String auth(Model model) {
        model.addAttribute("authData", new AuthData());
        return "auth";
    }

    @PostMapping
    public ModelAndView auth(ModelAndView modelAndView,
                             @ModelAttribute("authData") AuthData authData
    ) {

        User user = userService.login(authData);

        if (user != null) {
            modelAndView.addObject("user", user);
            modelAndView.setViewName("redirect:/");
        } else {
            modelAndView.addObject("message", INCORRECT);
            modelAndView.setViewName("auth");
        }
        return modelAndView;
    }

}
