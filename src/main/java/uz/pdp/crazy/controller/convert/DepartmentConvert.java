package uz.pdp.crazy.controller.convert;

import lombok.experimental.UtilityClass;
import uz.pdp.crazy.entity.DepartmentEntity;
import uz.pdp.crazy.entity.dto.DepartmentRequestDTO;

@UtilityClass
public class DepartmentConvert {
    public DepartmentEntity convertToEntity(DepartmentRequestDTO dto){
        return DepartmentEntity.builder()
                .name(dto.getName())
                .build();
    }
}
