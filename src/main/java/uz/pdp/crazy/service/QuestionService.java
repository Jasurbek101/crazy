package uz.pdp.crazy.service;

import org.springframework.stereotype.Service;
import uz.pdp.crazy.entity.QuestionEntity;
import uz.pdp.crazy.entity.TopicEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.QuestionRequestDTO;
import uz.pdp.crazy.repository.QuestionRepository;
import uz.pdp.crazy.repository.TopicRepository;

import java.util.List;
import java.util.Optional;

@Service

public class QuestionService {
    private final QuestionRepository questionRepository;
    private final TopicRepository topicRepository;

    public QuestionService(QuestionRepository questionRepository, TopicRepository topicRepository) {
        this.questionRepository = questionRepository;
        this.topicRepository = topicRepository;
    }

    public ApiResponse<List<QuestionEntity>> getAllQuestions(){
        List<QuestionEntity> all = questionRepository.findAll();
        if (all != null) {
            return ApiResponse.<List<QuestionEntity>>builder()
                    .message(" Here !!!")
                    .status(200)
                    .success(true)
                    .data(all)
                    .build();
        }else {
            return ApiResponse.<List<QuestionEntity>>builder()
                    .message(" Question isn't exist !!!")
                    .status(404)
                    .success(false)
                    .build();
        }
    }

    public ApiResponse add(QuestionRequestDTO dto){
        Optional<TopicEntity> optionalTopic = topicRepository.findById(dto.getTopicId());
        if (optionalTopic.isPresent()) {
            QuestionEntity questionEntity = QuestionEntity.of(dto);
            questionEntity.setTopicEntity(optionalTopic.get());
            QuestionEntity save = questionRepository.save(questionEntity);
            if (save != null) {
                return ApiResponse.builder()
                        .message(" Successfully added !!!")
                        .status(200)
                        .success(true)
                        .data(questionEntity)
                        .build();
            }else {
                return ApiResponse.builder()
                        .message(" Unuccessfully added")
                        .status(404)
                        .success(false)
                        .build();
            }
        }else {
            return ApiResponse.builder()
                    .message(" Topic isn't exist")
                    .status(404)
                    .success(false)
                    .build();
        }
    }

    public ApiResponse get(Long id){
        Optional<QuestionEntity> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {

                return ApiResponse.builder()
                        .message(" Here !!!")
                        .status(200)
                        .success(true)
                        .data(optionalQuestion.get())
                        .build();
        }else {
            return ApiResponse.builder()
                    .message(" Question isn't exist")
                    .status(404)
                    .success(false)
                    .build();
        }
    }

    public ApiResponse getByTopicId(Long id){
        Optional<TopicEntity> topicEntity = topicRepository.findById(id);
        if (topicEntity.isPresent()) {
            List<QuestionEntity> allByTopicEntity = questionRepository.findAllByTopicEntity(topicEntity.get());
            if (allByTopicEntity != null) {
                return ApiResponse.builder()
                        .message(" Here !!! ")
                        .status(200)
                        .data(allByTopicEntity)
                        .success(true)
                        .build();
            }else {
                return ApiResponse.builder()
                        .message("  Question isn't exist ")
                        .status(404)
                        .success(false)
                        .build();
            }
        }else {
            return ApiResponse.builder()
                    .message(" Topic doesn't find")
                    .status(404)
                    .success(false)
                    .build();
        }
    }

    public ApiResponse delete(Long id){
        Optional<QuestionEntity> questionEntity = questionRepository.findById(id);
        if (questionEntity.isPresent()) {
            questionRepository.deleteById(id);
            return ApiResponse.builder()
                    .message(" Here !!!")
                    .status(200)
                    .success(true)
                    .data(questionEntity.get())
                    .build();
        }else {
            return ApiResponse.builder()
                    .message(" Question isn't exist")
                    .status(404)
                    .success(false)
                    .build();
        }
    }




}
