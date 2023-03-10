package uz.pdp.crazy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.TopicRequestDTO;
import uz.pdp.crazy.service.TopicService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/topic")
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody TopicRequestDTO topicDTO){
        ApiResponse<?> add = topicService.add(topicDTO);
        return ResponseEntity.status(add.getStatus()).body(add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@RequestParam Long id){
        ApiResponse<?> topic = topicService.getTopic(id);
        return ResponseEntity.status(topic.getStatus()).body(topic);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<?> getTopicBySubjectId(@RequestParam Long id){
        ApiResponse<?> topicBySubjectId = topicService.getTopicBySubjectId(id);
        return ResponseEntity.status(topicBySubjectId.getStatus()).body(topicBySubjectId);
    }


    @GetMapping
    public ResponseEntity<?> getAllTopics(){
        ApiResponse<?> topic = topicService.getAllTopics();
        return ResponseEntity.status(topic.getStatus()).body(topic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        ApiResponse<?> deleteTopic = topicService.deleteTopic(id);
        return ResponseEntity.status(deleteTopic.getStatus()).body(deleteTopic);
    }

}
