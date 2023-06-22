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

        DepartmentEntity save = departmentRepository.save(DepartmentConvert.convertToEntity(dto));

        List<DepartmentEntity> departmentEntityList = subject.getDepartmentEntity();
        departmentEntityList.add(save);

        subject.setDepartmentEntity(departmentEntityList);

        SubjectEntity save1 = subjectRepository.save(subject);
        return ApiResponse.<DepartmentEntity>builder()
                .message(" Succesfully Added")
                .success(true)
                .data(save)
                .status(200)
                .build();
    }

    public ApiResponse<DepartmentEntity> getOneDepartment(Long id) {
        DepartmentEntity department = departmentRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format(" Department not fount with %s id", id))
        );
        return ApiResponse.<DepartmentEntity>builder()
                .status(200)
                .message(" Here !!! ")
                .data(department)
                .success(true)
                .build();
    }

    public ApiResponse<List<DepartmentEntity>> getAllDepartment() {
        List<DepartmentEntity> all = departmentRepository.findAll();
        return ApiResponse.<List<DepartmentEntity>>builder()
                .status(200)
                .message(" Here !!! ")
                .data(all)
                .success(true)
                .build();
    }

    public ApiResponse<DepartmentEntity> deleteDepartment(Long id) {
        DepartmentEntity department = departmentRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format(" Department not fount with %s id", id))
        );
        departmentRepository.delete(department);

        return ApiResponse.<DepartmentEntity>builder()
                .status(200)
                .message(" Here !!! ")
                .data(department)
                .success(true)
                .build();
    }

}
