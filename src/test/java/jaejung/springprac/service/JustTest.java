package jaejung.springprac.service;

import jaejung.springprac.domain.Member;
import jaejung.springprac.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.concurrent.CompletableFuture.anyOf;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

interface MyRowMapper<T>{
    T mapRow(String str, int count);
}

class JustTest {
    @Test
    void findAny_findFirst() {
        List<String> list = Arrays.asList("A","B","C","D");

        Optional<String> result = list.stream().findAny();
        System.out.println(result.get());

        result = list.stream().parallel().findAny();
        System.out.println(result.get());

        result = list.stream().findFirst();
        System.out.println(result.get());

//        assertTrue(result.isPresent());
//        assertThat(result.get(), anyOf(is("A"), is ("B"), is("C"), is("D")));
   }

    @Test
    void RowMapperTest(){
        MyRowMapper<String> temp = (str, count) -> {
            String str1 = String.valueOf(count);
            return str + str1;
        };
        System.out.println(temp.getClass());
        System.out.println(temp.getClass().getName());
        System.out.println(temp.mapRow("asdf", 12));
    }
}