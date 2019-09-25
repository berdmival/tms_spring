package by.tms.spring.application.controller;

import by.tms.spring.application.repository.HistoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(path = "/")
public class MainController {

    @Resource(name = "historyRepository")
    HistoryRepository repository;

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView,
                              @RequestParam(name = "name", required = false, defaultValue = "Guest") String name) {
        modelAndView.setViewName("index");
        modelAndView.addObject("name", name);
        modelAndView.addObject("history", repository.getHistory());
        return modelAndView;
    }
}
