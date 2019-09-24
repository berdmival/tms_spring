package by.tms.spring.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/auth")
public class AuthController {

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("name", "Guest");
        return modelAndView;
    }

    @GetMapping(path = "/auth")
    public ModelAndView index(ModelAndView modelAndView,
                              @RequestParam(name = "name", required = false, defaultValue = "Guest") String name) {
        modelAndView.setViewName("index");
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}
