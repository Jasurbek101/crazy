package uz.pdp.crazy.controller;

import jakarta.persistence.Persistence;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.crazy.entity.UserEntity;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.UserRequestDTO;
import uz.pdp.crazy.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/{id}")
    public ApiResponse<UserEntity> getUser(@PathVariable("id") Long id ){
        UserEntity userEntity = userService.getOneUser(id);
        return ApiResponse.<UserEntity>builder()
                .message(" Here !!! ")
                .status(200)
                .success(true)
                .data(userEntity)
                .build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    @GetMapping
    public ApiResponse<List<UserEntity>> getAllUsers(){
        List<UserEntity> userEntities = userService.getAllUsers();
        return ApiResponse.<List<UserEntity>>builder()
                .message(" All Users !!! ")
                .status(200)
                .success(true)
                .data(userEntities)
                .build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<UserEntity> delete(@PathVariable("id") Long id){
        UserEntity userEntity = userService.deleteUser(id);
        return ApiResponse.<UserEntity>builder()
                .message(" User succesfully deleted ")
                .status(200)
                .success(true)
                .data(userEntity)
                .build();
    }
}
