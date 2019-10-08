package by.tms.spring.exeption;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public String ex(Exception e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}
