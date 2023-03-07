package uz.pdp.crazy.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.crazy.entity.dto.TopicDTO;

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

    @ManyToOne
    private SubjectEntity subjectEntity;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "topicEntity",
            cascade = CascadeType.ALL
    )
    private List<QuestionEntity> questionEntities;

    public static TopicEntity of(TopicDTO topicDTO){
        return TopicEntity.builder()
                .name(topicDTO.getName())
                .description(topicDTO.getDescription())
                .questionEntities(topicDTO.getQuestionEntities())
                .build();
    }
}
