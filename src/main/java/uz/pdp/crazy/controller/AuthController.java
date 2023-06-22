package uz.pdp.crazy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.crazy.entity.dto.AuthenticationResponseDTO;
import uz.pdp.crazy.entity.dto.LoginRequestDTO;
import uz.pdp.crazy.entity.dto.RegisterRequestDTO;
import uz.pdp.crazy.service.AuthenticationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")

public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody RegisterRequestDTO requestDTO
    ) {
        return ResponseEntity.ok(authenticationService.register(requestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(
            @RequestBody LoginRequestDTO loginRequestDTO
    ) {
        return ResponseEntity.ok(authenticationService.login(loginRequestDTO));
    }
}

