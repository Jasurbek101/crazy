package uz.pdp.crazy.controller.convert;

import lombok.experimental.UtilityClass;
import uz.pdp.crazy.entity.UserEntity;
import uz.pdp.crazy.entity.dto.RegisterRequestDTO;
import uz.pdp.crazy.entity.dto.UserResponseDTO;
import uz.pdp.crazy.entity.enums.RoleEnam;


@UtilityClass
public class UserConvert {

    public UserEntity convertToEntity(RegisterRequestDTO requestDTO) {
        UserEntity user = new UserEntity();
        user.setFirstname(requestDTO.getFirstname());
        user.setLastname(requestDTO.getLastname());
        user.setPhone(requestDTO.getPhone());
        user.setPassword(requestDTO.getPassword());
        user.setRoleEnam(RoleEnam.ROLE_USER);
        return user;
    }

    public UserResponseDTO convertToResponseDTO(UserEntity user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .phone(user.getPhone())
                .roleEnam(user.getRoleEnam())
                .build();
    }
}

