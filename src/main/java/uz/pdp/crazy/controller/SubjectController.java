package uz.pdp.crazy.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.crazy.entity.SubjectEntity;
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
    public ResponseEntity addSubject(@RequestBody SubjectRequestDTO subjectRequestDTO){
        ApiResponse<?> add = subjectService.addSubject(subjectRequestDTO);
        return ResponseEntity.status(add.getStatus()).body(add.getData());
    }

    @GetMapping
    public ResponseEntity getAllSubjects(){
        ApiResponse<List<SubjectEntity>> allSubjects = subjectService.getAllSubjects();
        return ResponseEntity.status(allSubjects.getStatus()).body(allSubjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneSubject(@PathVariable Long id){
        ApiResponse<SubjectResponseDTO> subject = subjectService.getSubject(id);
        return ResponseEntity.status(subject.getStatus()).body(subject);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteSubject(@PathVariable Long id){
        ApiResponse<SubjectEntity> subject = subjectService.deleteSubject(id);
        return ResponseEntity.status(subject.getStatus()).body(subject);
    }

}
