package jaejung.springprac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("joinProc")
    public String joinProc() {
        return "joinProc";
    }
}
