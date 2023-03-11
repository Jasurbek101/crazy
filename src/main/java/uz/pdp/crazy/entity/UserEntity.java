package uz.pdp.crazy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.pdp.crazy.entity.dto.UserRequestDTO;
import uz.pdp.crazy.entity.enums.Role;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private String password;
    @OneToOne(mappedBy = "userEntity")
    @JsonIgnore
    private AvatarEntity avatarEntity;
    private int count = 0;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registeredTime = LocalDateTime.now();
    @JsonIgnore
    private LocalDateTime lastOperationTime;
    @Builder.Default
    private boolean active = true;
    @Enumerated(EnumType.STRING)
    private Role role;

    public static UserEntity of(UserRequestDTO dto){
        return UserEntity.builder()
                .username(dto.getUsername())
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .registeredTime(LocalDateTime.now())
                .password(dto.getPassword())
                .build();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
