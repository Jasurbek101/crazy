package uz.pdp.crazy.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequestDTO {
    private String name;
    private Long userId;
    private String cost;
}
