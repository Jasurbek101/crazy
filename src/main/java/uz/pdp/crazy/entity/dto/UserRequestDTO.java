package uz.pdp.crazy.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private String firstname;
    private String lastname;
    private String phone;
    private String password;
}
