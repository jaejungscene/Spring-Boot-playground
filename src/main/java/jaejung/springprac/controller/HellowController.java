package jaejung.springprac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HellowController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("template")
    public String templatehello(Model model){
        model.addAttribute("data", "templatehello()");
        return "12";
    }

    @GetMapping("hello-static.html")
    public String hello_static(Model model){
        model.addAttribute("data01", "data01~~~");
        return "hello-static";
    }

    @GetMapping("hello-mvc")
    public String

}
