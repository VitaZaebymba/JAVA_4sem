package ru.mirea.dto;
import com.sun.istack.NotNull;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.NotBlank;

@Setter
@ToString
public class StudentResponse {
    @NotNull
    private Long id;
    @NotBlank
    private String firstName;
    private String middleName;
    @NotBlank
    private String lastName;
}
