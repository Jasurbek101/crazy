package uz.pdp.crazy.controller.convert;

import lombok.experimental.UtilityClass;
import uz.pdp.crazy.entity.SubjectEntity;
import uz.pdp.crazy.entity.dto.SubjectRequestDTO;
import uz.pdp.crazy.entity.dto.SubjectResponseDTO;

@UtilityClass
public class SubjectConvert {
    public SubjectEntity convertToEntity(SubjectRequestDTO dto){
            return SubjectEntity.builder()
                    .name(dto.getName())
                    .cost(dto.getCost())
                    .build();
    }

    public SubjectResponseDTO convertToResponseDTO(SubjectEntity subject){
        return SubjectResponseDTO.builder()
                .id(subject.getId())
                .name(subject.getName())
                .cost(subject.getCost())
                .userNumber(subject.getUsersNumber())
                .cost(subject.getCost())
                .departmentEntityList(subject.getDepartmentEntity())
                .build();
    }

}
