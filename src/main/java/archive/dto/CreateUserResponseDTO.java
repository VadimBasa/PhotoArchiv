package archive.dto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponseDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private String secondName;
    private String fileName;
    private String chapter;
    private Integer manth;
    private Integer year;
    private String comment;
    private Date dateLoad;

}

