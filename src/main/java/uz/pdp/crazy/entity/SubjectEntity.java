package uz.pdp.crazy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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


}
