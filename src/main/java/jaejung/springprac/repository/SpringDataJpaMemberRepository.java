package jaejung.springprac.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import jaejung.springprac.domain.member.Member;

import java.util.Optional;
import java.util.function.Function;

//@Repository
public interface SpringDataJpaMemberRepository 
extends JpaRepository<Member, Long>, MemberRepository {
    //    Optional<Member> findByName(String name);

}
