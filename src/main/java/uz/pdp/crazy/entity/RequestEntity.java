package uz.pdp.crazy.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.crazy.entity.enums.RequestType;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean view = false;
    private LocalDateTime dateTime = LocalDateTime.now();

    @ManyToOne
    private UserEntity userEntity;

    @Enumerated(EnumType.STRING)
    private RequestType requestType;
}
