package jaejung.springprac.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/redis")
public class RedisSessionController {
    private final StringRedisTemplate stringRedisTemplate;

    @GetMapping("/setFruit")
    public String setFruit(@RequestParam String name) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("fruit", name);
        return "saved.";
    }

    @GetMapping("/getFruit")
    public String setFruit() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String fruitName = ops.get("fruit");
        return fruitName;
    }






    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String name) {
        session.setAttribute("name", name);
        return "saved.";
    }

    @GetMapping("/my-name")
    public String myName(HttpSession session) {
        String myName = (String)session.getAttribute("name");
        return myName;
    }
}
