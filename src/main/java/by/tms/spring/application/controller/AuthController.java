package by.tms.spring.application.controller;

import by.tms.spring.application.model.user.CalcUser;
import by.tms.spring.application.repository.CalcHistoryRepository;
import by.tms.spring.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "/auth")
public class AuthController {

    private static final String NAME_OR_PASSWORD_IS_INCORRECT_MESSAGE = "Name or password is incorrect!";

    private final UserService userService;

    @Autowired
    public AuthController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index() {
        return "auth";
    }

    @PostMapping
    public ModelAndView index(ModelAndView modelAndView,
                              //TODO session annotation
                              HttpSession session,
                              @RequestParam(name = "email") String email,
                              @RequestParam(name = "password") String password) {

        CalcUser user = (CalcUser) userService.login(email, password);

        if (user != null) {
            session.setAttribute("user", user);
            modelAndView.setViewName("redirect:/");
        } else {
            session.setAttribute("message", NAME_OR_PASSWORD_IS_INCORRECT_MESSAGE);
            modelAndView.setViewName("auth");
        }
        return modelAndView;
    }

}
