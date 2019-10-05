package by.tms.spring.controller;

import by.tms.spring.model.User;
import by.tms.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/reg")
public class RegController {

    private static final String USER_WITH_THE_SAME_EMAIL_IS_ALREADY_EXISTS = "User with the same email is already exists!";

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
    public String reg(@Valid @ModelAttribute("newUser") User user,
                      BindingResult bindingResult,
                      Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "reg";
        } else {
            if (userService.register(user)) {
                return "redirect:/auth";
            } else {
                model.addAttribute("message", USER_WITH_THE_SAME_EMAIL_IS_ALREADY_EXISTS);
                return "reg";
            }
        }

    }
}
