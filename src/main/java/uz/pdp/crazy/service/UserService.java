package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.crazy.entity.UserEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.UserRequestDTO;
import uz.pdp.crazy.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public ApiResponse<?> add(UserRequestDTO userRequestDTO) {
        Optional<UserEntity> byUsername = userRepository.findByUsername(userRequestDTO.getUsername());
        if (!byUsername.isPresent()) {
            UserEntity of = UserEntity.of(userRequestDTO);
            of.setActive(true);
            UserEntity save = userRepository.save(UserEntity.of(userRequestDTO));
            if (save != null) {
                return ApiResponse.builder()
                        .message(" User successfully added ")
                        .status(200)
                        .success(true)
                        .data(save)
                        .build();
            } else {
                return ApiResponse.builder()
                        .message(" User unsuccessfully added ")
                        .status(404)
                        .success(false)
                        .build();
            }
        } else {
            return ApiResponse.builder()
                    .message(" This username already exist ")
                    .status(200)
                    .success(false)
                    .build();
        }


    }

    public ApiResponse<?> checkUser(String emailOrPhone) {
        Optional<UserEntity> byEmail = userRepository.findByEmail(emailOrPhone);
        Optional<UserEntity> byPhone = userRepository.findByPhone(emailOrPhone);

        if (byEmail.isPresent()) {
            return ApiResponse.builder()
                    .message(" This email already exist")
                    .status(404)
                    .success(false)
                    .build();
        } else if (byPhone.isPresent()) {
            return ApiResponse.builder()
                    .message(" This phone already exist")
                    .status(404)
                    .success(false)
                    .build();
        } else {
            return ApiResponse.builder()
                    .message(" This email or password is empty")
                    .status(200)
                    .success(true)
                    .build();
        }
    }


    public ApiResponse<?> getOne(Long id) {
        Optional<UserEntity> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            return ApiResponse.builder()
                    .message(" Here !!! ")
                    .status(200)
                    .success(true)
                    .data(byId)
                    .build();
        }else {
            return ApiResponse.builder()
                    .message(" User not found ")
                    .status(404)
                    .success(false)
                    .build();
        }
    }

    public ApiResponse<?> getUsers() {
        List<UserEntity> all = userRepository.findAll();
        if (all != null) {
            return ApiResponse.builder()
                    .message(" Here !!! ")
                    .status(200)
                    .success(true)
                    .data(all)
                    .build();
        }else {
            return ApiResponse.builder()
                    .message(" Users not found ")
                    .status(404)
                    .success(false)
                    .build();
        }
    }

    public ApiResponse<?> delete(Long id) {
        userRepository.deleteById(id);
        Optional<UserEntity> byId = userRepository.findById(id);
        if (!byId.isPresent()) {
            return ApiResponse.builder()
                    .message(" User succesfully deleted ")
                    .status(200)
                    .success(true)
                    .data(byId)
                    .build();
        }else {
            return ApiResponse.builder()
                    .message(" User unsuccesfully deleted")
                    .status(404)
                    .success(false)
                    .build();
        }
    }
}
