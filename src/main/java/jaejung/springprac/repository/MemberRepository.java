package jaejung.springprac.repository;

import java.util.List;
import java.util.Optional;

import jaejung.springprac.domain.member.Member;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
