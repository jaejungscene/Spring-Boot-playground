package jaejung.springprac.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    final private UserService userService;

    @GetMapping("/test1")
    public void test1() {
        userService.createUserListWithTrans();
    }

    @GetMapping("/test2")
    public void test2() {
        userService.createUserListWithoutTrans();
    }
}
