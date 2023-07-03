package uz.pdp.crazy.controller;

import jakarta.persistence.Persistence;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.UserRequestDTO;
import uz.pdp.crazy.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable("id") Long id ){
        ApiResponse<?> one = userService.getOneUser(id);
        return ResponseEntity.status(one.getStatus()).body(one);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    @GetMapping
    public ResponseEntity getAllUsers(){
        ApiResponse<?> users = userService.getAllUsers();
        return ResponseEntity.status(users.getStatus()).body(users);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPERADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        ApiResponse<?> delete = userService.deleteUser(id);
        return ResponseEntity.status(delete.getStatus()).body(delete);
    }
}
