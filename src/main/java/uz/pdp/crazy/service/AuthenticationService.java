package uz.pdp.crazy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.crazy.config.JwtService;
import uz.pdp.crazy.controller.convert.UserConvert;
import uz.pdp.crazy.entity.UserEntity;
import uz.pdp.crazy.entity.dto.AuthenticationResponseDTO;
import uz.pdp.crazy.entity.dto.LoginRequestDTO;
import uz.pdp.crazy.entity.dto.RegisterRequestDTO;
import uz.pdp.crazy.entity.enums.RoleEnam;
import uz.pdp.crazy.exception.AuthenticationException;
import uz.pdp.crazy.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseDTO register(RegisterRequestDTO requestDTO) {

        UserEntity user = UserConvert.convertToEntity(requestDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));


        String jwtToken = jwtService.generateToken(userRepository.save(user));
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponseDTO login(LoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getPhone(),
                        loginRequestDTO.getPassword()
                )
        );
        var user = userRepository.findByPhone(loginRequestDTO.getPhone()).orElseThrow(
                AuthenticationException::new
        );
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
