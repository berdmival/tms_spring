package by.tms.spring.application.controller;

import by.tms.spring.application.repository.HistoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/auth")
public class AuthController {

    @Resource(name = "historyRepository")
    HistoryRepository repository;

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView,
                              @RequestParam(name = "name", required = false, defaultValue = "Guest") String name) {
        modelAndView.setViewName("auth");
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView index(ModelAndView modelAndView,
                              HttpServletRequest servletRequest,
                              @RequestParam(name = "name", required = false, defaultValue = "Guest") String name) {
        servletRequest.getSession().setAttribute("user", name);
        modelAndView.addObject("name", name);
        modelAndView.addObject("history", repository.getHistory());
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}
