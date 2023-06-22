package uz.pdp.crazy.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequestDTO {

    private String name;
    private String data;
    private String methodData;
    private Long topicId;
}
