package jaejung.springprac.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import jaejung.springprac.domain.Gender;
import jaejung.springprac.domain.member.Member;

import javax.sql.DataSource;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


// @Repository
public class JdbcTemplateMemberRepository implements MemberRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // public JdbcTemplateMemberRepository(DataSource datasource) {
    //     this.jdbcTemplate = new JdbcTemplate(datasource);
    // }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", member.getName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setId(key.longValue());
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        List<Member> result = jdbcTemplate.query("select * from member where id = ?",  memberRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = jdbcTemplate.query("select * from member where name = ?", memberRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from member", memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member member = Member.builder()
                                .id(rs.getLong("id"))
                                .name(rs.getString("name"))
                                .age(rs.getInt("age"))
//                                .birthDate(rs.getObject("birthDate", Date.class))
                                .birthDate(rs.getString("birthDate"))
//                                .gender(rs.getObject("gender", Gender.class))
                                .gender(rs.getString("gender"))
                                .build();
            return member;
        }; }
}
