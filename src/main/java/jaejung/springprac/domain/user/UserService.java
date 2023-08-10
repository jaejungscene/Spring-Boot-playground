package jaejung.springprac.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    final private UserRepository userRepository;

    @Transactional
    public void createUserListWithTrans(){
        for (int i = 0; i < 10; i++) {
            if(i==5) throw new RuntimeException();
            createUser(i);
        }
    }

    public void createUserListWithoutTrans(){
        for (int i = 0; i < 10; i++) {
            if(i==5) throw new RuntimeException();
            createUser(i);
        }
    }

    public User createUser(int index){
        User user = User.builder()
                .name("testname::"+index)
                .email("testemail::"+index)
                .build();

        userRepository.save(user);
        return user;
    }
}
