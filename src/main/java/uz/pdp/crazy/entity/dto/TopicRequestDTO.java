package uz.pdp.crazy.entity.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.crazy.entity.QuestionEntity;
import uz.pdp.crazy.entity.SubjectEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicRequestDTO {
    private String name;
    private String description;
    private Long subjectId;
}
