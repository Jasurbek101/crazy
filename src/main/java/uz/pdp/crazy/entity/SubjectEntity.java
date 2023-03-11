package uz.pdp.crazy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import uz.pdp.crazy.entity.dto.SubjectRequestDTO;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(allowGetters = true)
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public static SubjectEntity of(SubjectRequestDTO subjectDTO) {
        return SubjectEntity.builder()
                .title(subjectDTO.getTitle())
                .build();
    }

}
