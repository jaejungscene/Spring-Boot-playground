package jaejung.springprac;

import jaejung.springprac.domain.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
//@DataJpaTest
public class AccountDataTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void transferTest() {
        Long from = 1L;
        Long to = 2L;
        Long amount = 2000L;
        accountService.transferMoney(
                from,
                to,
                amount
        );
    }

}
