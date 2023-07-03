package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.crazy.entity.UserEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.exception.RecordNotFoundException;
import uz.pdp.crazy.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public ApiResponse<?> getOneUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format("Can not found user with id : ", id))
        );

        return ApiResponse.builder()
                .message(" Here !!! ")
                .status(200)
                .success(true)
                .data(userEntity)
                .build();

    }

    public ApiResponse<?> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return ApiResponse.builder()
                .message(" Here !!! ")
                .status(200)
                .success(true)
                .data(userEntities)
                .build();
    }

    public ApiResponse<?> deleteUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(String.format("Can not found user with id : ", id))
        );

        userRepository.deleteById(id);
        return ApiResponse.builder()
                .message(" User succesfully deleted ")
                .status(200)
                .success(true)
                .data(userEntity)
                .build();

    }

    public ApiResponse<?> me(String phone) {
        UserEntity userEntity = userRepository.findByPhone(phone).orElseThrow(
                () -> new RecordNotFoundException(String.format("Can not found user with phone : ", phone))
        );

        return ApiResponse.builder()
                .message(" User succesfully deleted ")
                .status(200)
                .success(true)
                .data(userEntity)
                .build();

    }

}
