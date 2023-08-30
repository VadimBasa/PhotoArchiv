package springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestDTO {
    private String firstName;
    private String lastName;
    private String sex;
    private Long age;
}

