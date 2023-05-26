package jaejung.springprac;

import jaejung.springprac.repository.JdbcMemberRepository;
import jaejung.springprac.repository.JdbcTemplateMemberRepository;
import jaejung.springprac.repository.MemberRepository;
import jaejung.springprac.repository.MemoryMemberRepository;
import jaejung.springprac.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println(dataSource);
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
