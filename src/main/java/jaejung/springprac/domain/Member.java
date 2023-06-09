package jaejung.springprac.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
