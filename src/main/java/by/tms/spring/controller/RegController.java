package by.tms.spring.controller;

import by.tms.spring.model.User;
import by.tms.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/reg")
public class RegController {

    private static final String CHECK_YOUR_INPUT_PLEASE_MESSAGE = "User with the same email is already exists!";

    private final UserService userService;

    public RegController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String reg(Model model) {
        model.addAttribute("newUser", new User());
        return "reg";
    }

    @PostMapping
    public ModelAndView reg(ModelAndView modelAndView,
                            @ModelAttribute("newUser") User user) {

        if (userService.register(user)) {
            modelAndView.setViewName("redirect:/auth");
        } else {
            modelAndView.setViewName("reg");
            modelAndView.addObject("message", CHECK_YOUR_INPUT_PLEASE_MESSAGE);
        }

        return modelAndView;
    }
}
