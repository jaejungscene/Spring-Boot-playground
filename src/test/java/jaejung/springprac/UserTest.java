package jaejung.springprac;

import jaejung.springprac.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        userService.createUserListWithTrans();
    }

    @Test
    public void test2(){
        userService.createUserListWithoutTrans();
    }
}
