package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.crazy.entity.SubjectEntity;
import uz.pdp.crazy.entity.TopicEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.TopicRequestDTO;
import uz.pdp.crazy.repository.SubjectRepository;
import uz.pdp.crazy.repository.TopicRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;
    private final SubjectRepository subjectRepository;

    public ApiResponse<?> add(TopicRequestDTO topicDTO) {
        Optional<TopicEntity> byName = topicRepository.findByName(topicDTO.getName());
        if (!byName.isPresent()) {
            TopicEntity topicEntity = TopicEntity.of(topicDTO);
            Optional<SubjectEntity> subject = subjectRepository.findById(topicEntity.getId());
            if(subject.isPresent()){
                topicEntity.setSubjectEntity(subject.get());
                TopicEntity save = topicRepository.save(topicEntity);
                if (save != null) {
                    return ApiResponse.builder()
                            .message(" Topic successfully added ")
                            .status(200)
                            .success(true)
                            .data(save)
                            .build();
                } else {
                    return ApiResponse.builder()
                            .message(" Topic unsuccessfully added ")
                            .status(404)
                            .success(false)
                            .build();
                }
            }else {
                return ApiResponse.builder()
                        .message(" Subject doesn't find ")
                        .status(404)
                        .success(false)
                        .build();
            }
        } else {
            return ApiResponse.builder()
                    .message(" This topic already exist ")
                    .status(400)
                    .success(false)
                    .build();
        }
    }

    public ApiResponse<?> getTopic(Long id) {
        Optional<TopicEntity> byId = topicRepository.findById(id);
        if (byId.isPresent()) {
            return ApiResponse.builder()
                    .message(" Here !!! ")
                    .status(200)
                    .success(true)
                    .data(byId.get())
                    .build();

        } else {
            return ApiResponse.builder()
                    .message(" This topic doesn't find  ")
                    .status(404)
                    .success(false)
                    .build();
        }
    }

    public ApiResponse<?> getAllTopics() {
        List<TopicEntity> all = topicRepository.findAll();
        if (all != null) {
            return ApiResponse.builder()
                    .message(" Here !!! ")
                    .status(200)
                    .success(true)
                    .data(all)
                    .build();

        } else {
            return ApiResponse.builder()
                    .message(" This subjects doesn't find  ")
                    .status(404)
                    .success(false)
                    .build();
        }
    }

    public ApiResponse<?> getTopicBySubjectId(Long id) {
        Optional<SubjectEntity> subject = subjectRepository.findById(id);
        if(subject.isPresent()){
            List<TopicEntity> allBySubjectEntityId = topicRepository.findAllBySubjectEntity(subject.get());
            if (allBySubjectEntityId != null) {
                return ApiResponse.builder()
                        .message(" Here !!! ")
                        .status(200)
                        .success(true)
                        .data(allBySubjectEntityId)
                        .build();

            } else {
                return ApiResponse.builder()
                        .message(" This topic doesn't find  ")
                        .status(404)
                        .success(false)
                        .build();
            }
        }else {
            return ApiResponse.builder()
                    .message(" Subject doesn't find ")
                    .status(404)
                    .success(false)
                    .build();
        }

    }

    public ApiResponse<?> deleteTopic(Long id) {
        Optional<TopicEntity> byId = topicRepository.findById(id);
        if (byId.isPresent()) {
            topicRepository.deleteById(id);
            return ApiResponse.builder()
                    .message(" Successfully deleted !!! ")
                    .status(200)
                    .success(true)
                    .data(byId.get())
                    .build();
        } else {
            return ApiResponse.builder()
                    .message(" This topic isn't exist ")
                    .status(404)
                    .success(false)
                    .build();
        }
    }



}
