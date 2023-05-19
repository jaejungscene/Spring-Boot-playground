package jaejung.springprac.service;

import jaejung.springprac.domain.Member;
import jaejung.springprac.repository.MemberRepository;
import jaejung.springprac.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService = new MemberService();
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    @AfterEach
    public void each(){
        memoryMemberRepository.clearStore();
    }
    @Test
    void join() {
        Member member = new Member();
        member.setName("spring");

        Long saveId = memberService.join(member);

        Member findMember = memberService.findOne(saveId).orElseThrow();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateMember(){
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


//        try {
//            memberService.join(member2);
//        }
//        catch(IllegalStateException e){
//            System.out.println("Successfully Error occur\n>  "+e);
//        }

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}