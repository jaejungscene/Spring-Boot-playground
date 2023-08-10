package jaejung.springprac;

import jaejung.springprac.domain.employee.Employee;
import org.junit.jupiter.api.Test;
import jakarta.persistence.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

interface MyRowMapper<T>{
    T mapRow(String str, int count);
}

class JustTest {
    @Test
    void JPATest(){
        int check = 1;
        EntityManagerFactory embfactory = Persistence.createEntityManagerFactory("basicjpa");
        EntityManager entityManager = embfactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        System.out.println("check"+check++);
        Employee emp = Employee.builder()
                .id(12L)
                .name("jaejung")
                .build();
        System.out.println("check"+check++);
        entityManager.persist(emp);
        System.out.println("check"+check++);
        entityTransaction.commit();
        System.out.println("check"+check++);
        entityManager.close();
        System.out.println("check"+check++);
        embfactory.close();
        System.out.println("check"+check++);
    }
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