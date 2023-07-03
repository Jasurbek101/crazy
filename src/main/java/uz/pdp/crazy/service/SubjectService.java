package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.crazy.controller.convert.SubjectConvert;
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

    public SubjectResponseDTO addSubject(SubjectRequestDTO subjectRequestDTO){
        if (subjectRequestDTO == null) {
            throw new RecordNotFoundException(" This subject is empty");
        }

        UserEntity userEntity = userRepository.findById(subjectRequestDTO.getUserId()).orElseThrow(
                () -> new RecordNotFoundException(String.format("Can not found user with id : ", subjectRequestDTO.getUserId()))
        );
        SubjectEntity subjectEntity = SubjectConvert.convertToEntity(subjectRequestDTO);
        subjectEntity.setUserEntity(userEntity);

        SubjectEntity savedSubject = subjectRepository.save(subjectEntity);
        SubjectResponseDTO subjectResponseDTO = SubjectConvert.convertToResponseDTO(subjectEntity);
        return subjectResponseDTO;
    }

    public SubjectResponseDTO getSubject(Long id){
        SubjectEntity subjectEntity = subjectRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format(" not found subject with id : ", id))
        );
        return SubjectConvert.convertToResponseDTO(subjectEntity);
    }


    public List<SubjectResponseDTO> getAllSubjects(){
        List<SubjectEntity> subjectEntityList = subjectRepository.findAll();
       return SubjectConvert.convertToResponseDTO(subjectEntityList);
    }


    public SubjectResponseDTO deleteSubject(Long id){
        SubjectEntity subjectEntity = subjectRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format(" not found subject with id : ", id))
        );

        subjectRepository.deleteById(id);
       return SubjectConvert.convertToResponseDTO(subjectEntity);
    }
}
