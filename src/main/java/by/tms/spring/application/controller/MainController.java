package by.tms.spring.application.controller;

import by.tms.spring.application.repository.HistoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/")
public class MainController {

    @Resource(name = "historyRepository")
    HistoryRepository repository;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index(ModelAndView modelAndView,
                              HttpServletRequest servletRequest,
                              @RequestParam(name = "name", required = false, defaultValue = "Guest") String name) {
        HttpSession session = servletRequest.getSession();
        String user = (String) session.getAttribute("user");
        modelAndView.setViewName("index");
        if (user == null) {
            modelAndView.addObject("name", name);
        } else {
            modelAndView.addObject("name", user);
            modelAndView.addObject("history", repository.getHistory());
        }
        return modelAndView;
    }
}
