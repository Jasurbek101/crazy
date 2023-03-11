package uz.pdp.crazy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class AvatarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    private List<AttachmentEntity> photos;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private UserEntity userEntity;
    private String personal;
    private String  aboutWork;
    private String hobby;

}
