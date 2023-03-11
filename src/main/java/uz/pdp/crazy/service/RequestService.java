package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.crazy.entity.*;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.RequestDTO;
import uz.pdp.crazy.entity.enums.RequestType;
import uz.pdp.crazy.repository.*;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final TopicRepository topicRepository;
    private final QuestionRepository  questionRepository;
    private final RequestRepository requestRepository;


    public void addSubject(RequestDTO requestDTO){

        Optional<UserEntity> userEntity = userRepository.findById(requestDTO.getUserId());

        if (userEntity.isPresent()) {
            Optional<SubjectEntity> subjectEntity = subjectRepository.findById(requestDTO.getProductId());
            if (subjectEntity.isPresent()) {
                RequestEntity requestEntity = RequestEntity.builder()
                        .userEntity(userEntity.get())
                        .subjectEntity(subjectEntity.get())
                        .requestType(RequestType.ADD_SUBJECT)
                        .build();
                requestRepository.save(requestEntity);

            }
        }

    }


}
