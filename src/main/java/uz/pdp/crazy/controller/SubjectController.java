package uz.pdp.crazy.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.crazy.controller.convert.SubjectConvert;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.SubjectRequestDTO;
import uz.pdp.crazy.entity.dto.SubjectResponseDTO;
import uz.pdp.crazy.service.SubjectService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subject")
@RestControllerAdvice
public class SubjectController {
    private final SubjectService subjectService;

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    @PostMapping
    public ApiResponse<SubjectResponseDTO> addSubject(@RequestBody SubjectRequestDTO subjectRequestDTO){
        SubjectResponseDTO subjectResponseDTO = subjectService.addSubject(subjectRequestDTO);
        return ApiResponse.<SubjectResponseDTO>builder()
                .status(200)
                .message("Successfully Added")
                .success(true)
                .data(subjectResponseDTO)
                .build();
    }

    @GetMapping
    public ApiResponse<List<SubjectResponseDTO>> getAllSubjects(){
        List<SubjectResponseDTO> subjectEntityList = subjectService.getAllSubjects();
        return ApiResponse.<List<SubjectResponseDTO>>builder()
                .status(200)
                .message(" That's All Subjects ")
                .success(true)
                .data(subjectEntityList)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<SubjectResponseDTO> getOneSubject(@PathVariable Long id){
        SubjectResponseDTO subjectResponseDTO = subjectService.getSubject(id);
        return ApiResponse.<SubjectResponseDTO>builder()
                .status(200)
                .message(" This is subject")
                .success(true)
                .data(subjectResponseDTO)
                .build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<SubjectResponseDTO> deleteSubject(@PathVariable Long id){
        SubjectResponseDTO subjectResponseDTO = subjectService.deleteSubject(id);
        return ApiResponse.<SubjectResponseDTO>builder()
                .status(200)
                .message(" Deleted !!!")
                .success(true)
                .data(subjectResponseDTO)
                .build();
    }

}
