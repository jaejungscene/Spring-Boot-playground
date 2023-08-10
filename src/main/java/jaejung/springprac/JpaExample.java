package jaejung.springprac;

import jaejung.springprac.domain.employee.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaExample {
    public static void main(String[] args) {
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
}
