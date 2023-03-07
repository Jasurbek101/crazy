package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.crazy.entity.SubjectEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.SubjectDTO;
import uz.pdp.crazy.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public ApiResponse<?> add(SubjectDTO subjectDTO) {
        Optional<SubjectEntity> byTitle = subjectRepository.findByTitle(subjectDTO.getTitle());
        if (!byTitle.isPresent()) {
            SubjectEntity subjectEntity = subjectRepository.save(SubjectEntity.of(subjectDTO));
            if (subjectEntity != null) {
                return ApiResponse.builder()
                        .message(" Subject successfully added ")
                        .status(200)
                        .success(true)
                        .data(subjectEntity)
                        .build();
            } else {
                return ApiResponse.builder()
                        .message(" Subject unsuccessfully added ")
                        .status(404)
                        .success(false)
                        .build();
            }
        } else {
            return ApiResponse.builder()
                    .message(" This subject already exist ")
                    .status(400)
                    .success(false)
                    .build();
        }
    }

    public ApiResponse<?> getSubject(Long id) {
        Optional<SubjectEntity> byId = subjectRepository.findById(id);
        if (byId.isPresent()) {
                return ApiResponse.builder()
                        .message(" Here !!! ")
                        .status(200)
                        .success(true)
                        .data(byId.get())
                        .build();

        } else {
            return ApiResponse.builder()
                    .message(" This subject doesn't find  ")
                    .status(404)
                    .success(false)
                    .build();
        }
    }

    public ApiResponse<?> getAllSubjects() {
        List<SubjectEntity> all = subjectRepository.findAll();
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
    public ApiResponse<?> deleteSubject(Long id) {
        Optional<SubjectEntity> byId = subjectRepository.findById(id);
        if (byId.isPresent()) {
            subjectRepository.deleteById(id);
            return ApiResponse.builder()
                    .message(" Successfully deleted !!! ")
                    .status(200)
                    .success(true)
                    .data(byId.get())
                    .build();
        } else {
            return ApiResponse.builder()
                    .message(" This subjects doesn't find  ")
                    .status(404)
                    .success(false)
                    .build();
        }
    }

}
