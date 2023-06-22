package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.crazy.entity.UserEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.UserRequestDTO;
import uz.pdp.crazy.exception.AlreadyExistsException;
import uz.pdp.crazy.exception.RecordNotFoundException;
import uz.pdp.crazy.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

//    public ApiResponse<?> checkUser(String emailOrPhone) {
//        Optional<UserEntity> byEmail = userRepository.findByEmail(emailOrPhone);
//        Optional<UserEntity> byPhone = userRepository.findByPhone(emailOrPhone);
//
//        if (byEmail.isPresent()) {
//            return ApiResponse.builder()
//                    .message(" This email already exist")
//                    .status(404)
//                    .success(false)
//                    .build();
//        } else if (byPhone.isPresent()) {
//            return ApiResponse.builder()
//                    .message(" This phone already exist")
//                    .status(404)
//                    .success(false)
//                    .build();
//        } else {
//            return ApiResponse.builder()
//                    .message(" This email or password is empty")
//                    .status(200)
//                    .success(true)
//                    .build();
//        }
//    }


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
        List<UserEntity> all = userRepository.findAll();
        return ApiResponse.builder()
                .message(" Here !!! ")
                .status(200)
                .success(true)
                .data(all)
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

}
