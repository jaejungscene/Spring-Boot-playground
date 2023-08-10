package jaejung.springprac.domain.account.service;

import jaejung.springprac.domain.account.Account;
import jaejung.springprac.domain.account.repository.AccountRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final EntityManager entityManager;
    private final AccountRepository accountRepository;

    public void register(Account account){
        accountRepository.save(account);
    }

    @Transactional
    public void transferMoney(Long from, Long to, Long amount) {
        transfer(from, to, amount);
    }

    @Transactional
    public void transfer(Long from, Long to, Long amount) {
        minusMoney(from, amount);
//        int zero = 0/0;
        plusMoney(to, amount);
    }

    @Transactional
    public void plusMoney(Long id, Long amount){
        Account account = accountRepository.findById(id).get();
        if(account != null)
            account.plusMoney(amount);
    }

    @Transactional
    public void minusMoney(Long id, Long amount){
        Account account = accountRepository.findById(id).get();
        if(account != null)
            account.minusMoney(amount);
    }

    @Transactional
    public void updateName(Long id) {
        Account account = accountRepository.findById(id).get();

        account.updateName("asd");
        account.plusMoney(100L);
    }

    @PostConstruct
    public void init() throws Exception
    {
        System.out.println(
                "---------------2> %s "
                .formatted(this.getClass().getName()));
    }
}
