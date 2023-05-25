package jaejung.springprac;

import jaejung.springprac.repository.MemberRepository;
import jaejung.springprac.repository.MemoryMemberRepository;
import jaejung.springprac.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
