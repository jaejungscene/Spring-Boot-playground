package jaejung.springprac.controller;

import jaejung.springprac.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jaejung.springprac.domain.member.MemberDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    final private MemberService memberService;

    @GetMapping("/member/all")
    public List<MemberDto> getAllMember() {
        return memberService.findAllMembers();
    }

    @GetMapping("/member/{memberId}")
    public MemberDto getOneMemberBy(@PathVariable Long memberId) {
        return memberService.findOneBy(memberId);
    }

    @GetMapping("/member") // member?name={name}
    public MemberDto getOneMemberBy(@RequestParam String name) {
        return memberService.findOneBy(name);
    }

//    @GetMapping("/member/{age}")
//    public List<MemberDto> getMembersBy(@PathVariable Integer age){
//        return memberService.findAllBy(age);
//    }

    @PostMapping ("/member")
    public MemberDto register(@RequestBody MemberDto member){
        System.out.println(member);
        return memberService.registerMember(member);
    }

    @DeleteMapping ("/member/{memberId}")
    public MemberDto deleteOneMember(@PathVariable Long memberId){
        return memberService.deleteOneMemberById(memberId);
    }
}
