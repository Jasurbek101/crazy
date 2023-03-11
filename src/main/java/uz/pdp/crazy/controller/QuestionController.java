package uz.pdp.crazy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.crazy.entity.QuestionEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.QuestionRequestDTO;
import uz.pdp.crazy.service.QuestionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity add(@RequestBody QuestionRequestDTO dto){
        ApiResponse add = questionService.add(dto);
        return ResponseEntity.status(add.getStatus()).body(add);
    }

    @GetMapping
    public ResponseEntity gettAll(){
        ApiResponse<List<QuestionEntity>> allQuestions = questionService.getAllQuestions();
        return ResponseEntity.status(allQuestions.getStatus()).body(allQuestions);
    }

    @GetMapping("/topic/{id}")
    public ResponseEntity getByTopicId(@RequestParam Long id){
        ApiResponse<List<QuestionEntity>> allQuestions = questionService.getByTopicId(id);
        return ResponseEntity.status(allQuestions.getStatus()).body(allQuestions);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@RequestParam Long id){
        ApiResponse<List<QuestionEntity>> listApiResponse = questionService.get(id);
        return ResponseEntity.status(listApiResponse.getStatus()).body(listApiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        ApiResponse<List<QuestionEntity>> questionDelete = questionService.delete(id);
        return ResponseEntity.status(questionDelete.getStatus()).body(questionDelete);
    }

}
