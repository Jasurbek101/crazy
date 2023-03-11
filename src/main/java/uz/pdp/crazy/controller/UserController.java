package uz.pdp.crazy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.crazy.entity.dto.ApiResponse;
import uz.pdp.crazy.entity.dto.UserRequestDTO;
import uz.pdp.crazy.service.UserService;

//@CrossOrigin(origins = "http://localhost:3002/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity add(@RequestBody UserRequestDTO requestDTO) {
        ApiResponse<?> add = userService.add(requestDTO);
        return ResponseEntity.status(add.getStatus()).body(add.getData());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable("id") Long id) {
        ApiResponse<?> one = userService.getOne(id);
        return ResponseEntity.status(one.getStatus()).body(one);
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        ApiResponse<?> users = userService.getUsers();
        return ResponseEntity.status(users.getStatus()).body(users);
    }

    @PutMapping
    public ResponseEntity updateUser(
            @RequestBody UserRequestDTO dto,
            @PathVariable Long id
    ) {
        ApiResponse<?> users = userService.getUsers();
        return ResponseEntity.status(users.getStatus()).body(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        ApiResponse<?> delete = userService.delete(id);
        return ResponseEntity.status(delete.getStatus()).body(delete);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity update(@RequestParam("id") Long id){
//
//
//        return ResponseEntity.status(delete.getStatus()).body(delete.getData());
//    }


}
