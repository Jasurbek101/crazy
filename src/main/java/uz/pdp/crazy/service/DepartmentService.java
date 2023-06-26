package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.crazy.controller.convert.DepartmentConvert;
import uz.pdp.crazy.entity.DepartmentEntity;
import uz.pdp.crazy.entity.SubjectEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
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

    public ApiResponse<DepartmentEntity> addDepartment(DepartmentRequestDTO dto) {
        SubjectEntity subject = subjectRepository.findById(dto.getSubjectId()).orElseThrow(
                () -> new RecordNotFoundException(String.format(" Subject not fount with %s id", dto.getSubjectId()))
        );

        DepartmentEntity departmentEntity = departmentRepository.save(DepartmentConvert.convertToEntity(dto));

        List<DepartmentEntity> departmentEntityList = subject.getDepartmentEntities();
        departmentEntityList.add(departmentEntity);

        subject.setDepartmentEntities(departmentEntityList);

        SubjectEntity subjectEntity = subjectRepository.save(subject);
        return ApiResponse.<DepartmentEntity>builder()
                .message(" Succesfully Added")
                .success(true)
                .data(departmentEntity)
                .status(200)
                .build();
    }

    public ApiResponse<DepartmentEntity> getOneDepartment(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format(" Department not fount with %s id", id))
        );
        return ApiResponse.<DepartmentEntity>builder()
                .status(200)
                .message(" Here !!! ")
                .data(departmentEntity)
                .success(true)
                .build();
    }

    public ApiResponse<List<DepartmentEntity>> getAllDepartment() {
        List<DepartmentEntity> departmentEntityList = departmentRepository.findAll();
        return ApiResponse.<List<DepartmentEntity>>builder()
                .status(200)
                .message(" Here !!! ")
                .data(departmentEntityList)
                .success(true)
                .build();
    }

    public ApiResponse<DepartmentEntity> deleteDepartment(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format(" Department not fount with %s id", id))
        );
        departmentRepository.delete(departmentEntity);

        return ApiResponse.<DepartmentEntity>builder()
                .status(200)
                .message(" Here !!! ")
                .data(departmentEntity)
                .success(true)
                .build();
    }

}
