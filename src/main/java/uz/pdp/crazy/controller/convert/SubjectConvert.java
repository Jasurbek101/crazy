package uz.pdp.crazy.controller.convert;

import lombok.experimental.UtilityClass;
import uz.pdp.crazy.entity.SubjectEntity;
import uz.pdp.crazy.entity.dto.SubjectRequestDTO;
import uz.pdp.crazy.entity.dto.SubjectResponseDTO;

import java.util.LinkedList;
import java.util.List;

@UtilityClass
public class SubjectConvert {
    public SubjectEntity convertToEntity(SubjectRequestDTO dto) {
        SubjectEntity subjectEntity = new SubjectEntity();

        subjectEntity.setName(dto.getName());
        subjectEntity.setUsersNumber(0L);
        subjectEntity.setCost(dto.getCost());

        return subjectEntity;
    }

    public SubjectResponseDTO convertToResponseDTO(SubjectEntity subject) {
        return SubjectResponseDTO.builder()
                .id(subject.getId())
                .name(subject.getName())
                .cost(subject.getCost())
                .userNumber(subject.getUsersNumber())
                .user(UserConvert.convertToResponseDTO(subject.getUserEntity()))
                .cost(subject.getCost())
                .departmentEntityList(subject.getDepartmentEntities())
                .build();
    }

    public List<SubjectResponseDTO> convertToResponseDTO(List<SubjectEntity> subject) {
        List<SubjectResponseDTO> subjectList = new LinkedList<>();

        for (SubjectEntity subjectEntity : subject) {
            subjectList.add(convertToResponseDTO(subjectEntity));
        }
        return subjectList;
    }

}
