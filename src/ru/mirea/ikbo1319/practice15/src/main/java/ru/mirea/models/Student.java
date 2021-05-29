package ru.mirea.models;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Group group;
    @Column(nullable = false, length = 20)
    private String firstName;
    @Column(length = 20)
    private String middleName;
    @Column(nullable = false, length = 20)
    private String lastName;
}
