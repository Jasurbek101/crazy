package uz.pdp.crazy.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.crazy.entity.dto.TopicRequestDTO;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class TopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private SubjectEntity subjectEntity;

    public static TopicEntity of(TopicRequestDTO topicDTO){
        return TopicEntity.builder()
                .name(topicDTO.getName())
                .description(topicDTO.getDescription())
                .build();
    }
}
