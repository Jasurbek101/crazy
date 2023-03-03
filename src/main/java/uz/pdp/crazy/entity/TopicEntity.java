package uz.pdp.crazy.entity;

import jakarta.persistence.*;
import lombok.*;

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



}
