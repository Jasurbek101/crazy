package uz.pdp.crazy.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.crazy.entity.enums.RoleEnam;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String phone;
    private RoleEnam roleEnam;
}
