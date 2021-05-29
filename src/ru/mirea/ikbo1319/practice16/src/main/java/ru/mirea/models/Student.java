package ru.mirea.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    @ManyToOne
    private Group group;
    @JsonIgnore
    private String firstName;
    @Column(length = 20)
    private String middleName;
    @Column(nullable = false, length = 20)
    private String lastName;
}
