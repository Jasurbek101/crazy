package uz.pdp.crazy.controller.convert;

import lombok.experimental.UtilityClass;
import uz.pdp.crazy.entity.DepartmentEntity;
import uz.pdp.crazy.entity.dto.DepartmentRequestDTO;

@UtilityClass
public class DepartmentConvert {
    public DepartmentEntity convertToEntity(DepartmentRequestDTO dto) {
        DepartmentEntity department = new DepartmentEntity();
        department.setName(dto.getName());

        return department;
    }
}
