package uz.pdp.crazy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.crazy.entity.DepartmentEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.DepartmentRequestDTO;
import uz.pdp.crazy.service.DepartmentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    public ApiResponse<DepartmentEntity> addDepartment(@RequestBody DepartmentRequestDTO dto){
        DepartmentEntity departmentEntity = departmentService.addDepartment(dto);
        return ApiResponse.<DepartmentEntity>builder()
                .message(" Succesfully Added ")
                .success(true)
                .data(departmentEntity)
                .status(200)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<DepartmentEntity> getOneDepartment(@PathVariable Long id){
        DepartmentEntity department = departmentService.getOneDepartment(id);
        return ApiResponse.<DepartmentEntity>builder()
                .message(" Here !!! ")
                .success(true)
                .data(department)
                .status(200)
                .build();
    }

    @GetMapping
    public ApiResponse<List<DepartmentEntity>> getAllDepartment(){
        List<DepartmentEntity> departmentEntityList = departmentService.getAllDepartments();
        return ApiResponse.<List<DepartmentEntity>>builder()
                .status(200)
                .message(" That's All !!! ")
                .data(departmentEntityList)
                .success(true)
                .build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    public ApiResponse<DepartmentEntity> deleteDepartment(@PathVariable Long id){
        DepartmentEntity departmentEntity = departmentService.deleteDepartment(id);
        return ApiResponse.<DepartmentEntity>builder()
                .status(200)
                .message(" Succesfully Deleted ")
                .data(departmentEntity)
                .success(true)
                .build();
    }



}
