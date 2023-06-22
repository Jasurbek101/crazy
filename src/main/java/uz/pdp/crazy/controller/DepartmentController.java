package uz.pdp.crazy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addDepartment(@RequestBody DepartmentRequestDTO dto){
        ApiResponse<DepartmentEntity> department = departmentService.addDepartment(dto);
        return ResponseEntity.status(department.getStatus()).body(department);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneDepartment(@PathVariable Long id){
        ApiResponse<DepartmentEntity> department = departmentService.getOneDepartment(id);
        return ResponseEntity.status(department.getStatus()).body(department);
    }

    @GetMapping
    public ResponseEntity<?> getAllDepartment(){
        ApiResponse<List<DepartmentEntity>> department = departmentService.getAllDepartment();
        return ResponseEntity.status(department.getStatus()).body(department);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id){
        ApiResponse<DepartmentEntity> department = departmentService.deleteDepartment(id);
        return ResponseEntity.status(department.getStatus()).body(department);
    }



}
