package uz.pdp.crazy.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import uz.pdp.crazy.entity.dto.RequestDTO;
import uz.pdp.crazy.entity.enums.RequestType;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private LocalDateTime dateTime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    private SubjectEntity subjectEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    private TopicEntity topicEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    private QuestionEntity questionEntity;

    @Enumerated(EnumType.STRING)
    private RequestType requestType;


}
