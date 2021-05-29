package ru.mirea.models;
import lombok.*;

@Getter
@Setter
@ToString
public class Student {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
}
