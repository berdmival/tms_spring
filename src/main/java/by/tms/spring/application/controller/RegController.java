package by.tms.spring.application.controller;

import by.tms.spring.application.model.user.CalcUser;
import by.tms.spring.application.repository.CalcHistoryRepository;
import by.tms.spring.application.service.UserService;
import by.tms.spring.application.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(path = "/reg")
public class RegController {

    private static final String CHECK_YOUR_INPUT_PLEASE_MESSAGE = "User with the same email is already exists!";

    private final UserService userService;

    @Autowired
    public RegController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index() {
        return "reg";
    }

    @PostMapping
    public ModelAndView index(ModelAndView modelAndView,
                              @RequestParam(name = "name") String name,
                              @RequestParam(name = "email") String email,
                              @RequestParam(name = "age") int age,
                              @RequestParam(name = "password") String password) {

        if (userService.register(new CalcUser(name, email, age, password))) {
            modelAndView.setViewName("redirect:/auth");
        } else {
            modelAndView.setViewName("reg");
            modelAndView.addObject("message", CHECK_YOUR_INPUT_PLEASE_MESSAGE);
        }

        return modelAndView;
    }
}
