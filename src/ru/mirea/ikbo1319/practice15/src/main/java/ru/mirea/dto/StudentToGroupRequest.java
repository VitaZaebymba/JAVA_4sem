package ru.mirea.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import javax.validation.constraints.NotBlank;

@Getter
@ToString
@AllArgsConstructor
public class StudentToGroupRequest {
    @NotBlank
    private String groupName;
    @NotBlank
    private String studentFirstName;
    private String studentMiddleName;
    @NotBlank
    private String studentLastName;
}
