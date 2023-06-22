package uz.pdp.crazy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    private List<VideoEntity> videoEntity;
}
