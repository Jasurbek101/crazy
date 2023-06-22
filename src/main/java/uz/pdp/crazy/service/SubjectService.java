package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.crazy.controller.convert.SubjectConvert;
import uz.pdp.crazy.controller.convert.UserConvert;
import uz.pdp.crazy.entity.SubjectEntity;
import uz.pdp.crazy.entity.UserEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.SubjectRequestDTO;
import uz.pdp.crazy.entity.dto.SubjectResponseDTO;
import uz.pdp.crazy.exception.RecordNotFoundException;
import uz.pdp.crazy.repository.SubjectRepository;
import uz.pdp.crazy.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    public ApiResponse<SubjectResponseDTO> addSubject(SubjectRequestDTO subjectRequestDTO){
        if (subjectRequestDTO == null) {
            throw new RecordNotFoundException(" This subject is empty");
        }

        UserEntity userEntity = userRepository.findById(subjectRequestDTO.getUserId()).orElseThrow(
                () -> new RecordNotFoundException(String.format("Can not found user with id : ", subjectRequestDTO.getUserId()))
        );
        SubjectEntity subject = SubjectConvert.convertToEntity(subjectRequestDTO);
        subject.setUserEntity(userEntity);

        SubjectEntity save = subjectRepository.save(subject);

        return ApiResponse.<SubjectResponseDTO>builder()
                .status(200)
                .message("Successfully Added")
                .success(true)
                .data(SubjectConvert.convertToResponseDTO(subject))
                .build();
    }

    public ApiResponse<SubjectResponseDTO> getSubject(Long id){
        SubjectEntity subjectEntity = subjectRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format(" not found subject with id : ", id))
        );
        SubjectResponseDTO subject= SubjectConvert.convertToResponseDTO(subjectEntity);

        return ApiResponse.<SubjectResponseDTO>builder()
                .status(200)
                .message(" This is ...")
                .success(true)
                .data(subject)
                .build();
    }


    public ApiResponse<List<SubjectResponseDTO>> getAllSubjects(){
        List<SubjectEntity> subjectRepositoryAll = subjectRepository.findAll();

        return ApiResponse.<List<SubjectResponseDTO>>builder()
                .status(200)
                .message(" Here !!!")
                .success(true)
                .data(SubjectConvert.convertToResponseDTO(subjectRepositoryAll))
                .build();
    }


    public ApiResponse<SubjectResponseDTO> deleteSubject(Long id){
        SubjectEntity subjectEntity = subjectRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format(" not found subject with id : ", id))
        );

        subjectRepository.deleteById(id);
        return ApiResponse.<SubjectResponseDTO>builder()
                .status(200)
                .message(" Deleted !!!")
                .success(true)
                .data(SubjectConvert.convertToResponseDTO(subjectEntity))
                .build();
    }





}
