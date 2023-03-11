package uz.pdp.crazy.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.crazy.entity.dto.QuestionRequestDTO;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String data;
    private String methodData;
    @ManyToOne(fetch = FetchType.EAGER)
    private TopicEntity topicEntity;

    public static QuestionEntity of(QuestionRequestDTO dto) {
        return QuestionEntity.builder()
                .name(dto.getName())
                .data(dto.getData())
                .methodData(dto.getMethodData())
                .build();

    }
}
