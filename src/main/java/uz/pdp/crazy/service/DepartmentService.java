package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.crazy.controller.convert.DepartmentConvert;
import uz.pdp.crazy.entity.DepartmentEntity;
import uz.pdp.crazy.entity.SubjectEntity;
import uz.pdp.crazy.entity.dto.DepartmentRequestDTO;
import uz.pdp.crazy.exception.RecordNotFoundException;
import uz.pdp.crazy.repository.DepartmentRepository;
import uz.pdp.crazy.repository.SubjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final SubjectRepository subjectRepository;

    public DepartmentEntity addDepartment(DepartmentRequestDTO dto) {
        SubjectEntity subject = subjectRepository.findById(dto.getSubjectId()).orElseThrow(
                () -> new RecordNotFoundException(String.format(" Subject not fount with %s id", dto.getSubjectId()))
        );

        DepartmentEntity departmentEntity = departmentRepository.save(DepartmentConvert.convertToEntity(dto));

        List<DepartmentEntity> departmentEntityList = subject.getDepartmentEntities();
        departmentEntityList.add(departmentEntity);

        subject.setDepartmentEntities(departmentEntityList);
        subjectRepository.save(subject);

        return departmentEntity;
    }

    public DepartmentEntity getOneDepartment(Long id) {
        return departmentRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format(" Department not fount with [%s] id", id))
        );
    }

    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public DepartmentEntity deleteDepartment(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format(" Department not fount with %s id", id))
        );
        departmentRepository.delete(departmentEntity);
        return departmentEntity;
    }

}
