package jaejung.springprac.controller.restApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jaejung.springprac.domain.student.MemberDto;

@RestController
public class MemberController {
    @GetMapping(value = "restApi/member")    
    public MemberDto register(@RequestBody MemberDto memberDto){
        return memberDto;
    }
    
}
