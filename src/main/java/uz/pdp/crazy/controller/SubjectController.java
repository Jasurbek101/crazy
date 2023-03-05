package uz.pdp.crazy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.SubjectDTO;
import uz.pdp.crazy.service.SubjectService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody SubjectDTO subjectDTO){
        ApiResponse<?> add = subjectService.add(subjectDTO);
        return ResponseEntity.status(add.getStatus()).body(add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubject(@RequestParam Long id){
        ApiResponse<?> subject = subjectService.getSubject(id);
        return ResponseEntity.status(subject.getStatus()).body(subject);
    }

    @GetMapping
    public ResponseEntity<?> getAllSubjects(){
        ApiResponse<?> allSubjects = subjectService.getAllSubjects();
        return ResponseEntity.status(allSubjects.getStatus()).body(allSubjects);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@RequestParam Long id){
        ApiResponse<?> deleteSubject = subjectService.deleteSubject(id);
        return ResponseEntity.status(deleteSubject.getStatus()).body(deleteSubject);
    }

}
