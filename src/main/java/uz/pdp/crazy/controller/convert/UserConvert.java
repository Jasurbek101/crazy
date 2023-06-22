package uz.pdp.crazy.controller.convert;

import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import uz.pdp.crazy.entity.UserEntity;
import uz.pdp.crazy.entity.dto.RegisterRequestDTO;
import uz.pdp.crazy.entity.dto.UserResponseDTO;
import uz.pdp.crazy.entity.enums.RoleEnam;


@UtilityClass
public class UserConvert {

    public UserEntity convertToEntity(RegisterRequestDTO requestDTO) {
        return UserEntity.builder()
                .firstname(requestDTO.getFirstname())
                .lastname(requestDTO.getLastname())
                .phone(requestDTO.getPhone())
                .password(requestDTO.getPassword())
                .roleEnam(RoleEnam.ROLE_USER)
                .build();
    }

    public UserResponseDTO convertToResponseDTO(UserEntity user){
        return UserResponseDTO.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .phone(user.getPhone())
                .roleEnam(user.getRoleEnam())
                .build();
    }


}

