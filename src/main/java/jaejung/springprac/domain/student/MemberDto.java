package jaejung.springprac.domain.student;

import java.sql.Date;

import jaejung.springprac.domain.Gender;

public record MemberDto(
    Long id,
    String name,
    Integer age,
    Date birthDate,
    Gender gender
) 
{ }
