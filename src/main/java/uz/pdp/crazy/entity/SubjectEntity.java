package uz.pdp.crazy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity(name = "subjects")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Builder.Default
    private Long usersNumber = 0L;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    private String cost;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id",referencedColumnName = "id")
    private List<DepartmentEntity> departmentEntity;
    @Builder.Default
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();

}
