package uz.pdp.crazy.controller.convert;

import lombok.experimental.UtilityClass;
import uz.pdp.crazy.entity.SubjectEntity;
import uz.pdp.crazy.entity.dto.SubjectRequestDTO;
import uz.pdp.crazy.entity.dto.SubjectResponseDTO;

import java.util.LinkedList;
import java.util.List;

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
                .user(UserConvert.convertToResponseDTO(subject.getUserEntity()))
                .cost(subject.getCost())
                .departmentEntityList(subject.getDepartmentEntity())
                .build();
    }

    public List<SubjectResponseDTO> convertToResponseDTO(List<SubjectEntity> subject){
        List<SubjectResponseDTO> subjectList = new LinkedList<>();

        for (SubjectEntity subjectEntity : subject) {
            subjectList.add(convertToResponseDTO(subjectEntity));
        }
        return subjectList;
    }

}
