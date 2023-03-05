package uz.pdp.crazy.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.crazy.entity.TopicEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private String title;
    private List<TopicEntity> topicEntities;
}
