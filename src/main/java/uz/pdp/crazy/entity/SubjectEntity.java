package uz.pdp.crazy.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.crazy.entity.dto.SubjectDTO;
import uz.pdp.crazy.entity.dto.UserRequestDTO;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "subjectEntity",
            cascade = CascadeType.ALL
    )
    private List<TopicEntity> topicEntities;

    public static SubjectEntity of(SubjectDTO subjectDTO){
        return SubjectEntity.builder()
                .title(subjectDTO.getTitle())
                .topicEntities(subjectDTO.getTopicEntities())
                .build();
    }

}
