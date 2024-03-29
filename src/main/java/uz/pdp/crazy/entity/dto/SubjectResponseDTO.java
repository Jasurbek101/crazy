package uz.pdp.crazy.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.crazy.entity.DepartmentEntity;
import uz.pdp.crazy.entity.UserEntity;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponseDTO {
    private Long id;
    private String name;
    private Long userNumber;
    private UserResponseDTO user;
    private String cost;
    private List<DepartmentEntity> departmentEntityList;
}