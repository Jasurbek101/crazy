package uz.pdp.crazy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "videos")
@NoArgsConstructor
@Setter
@Getter
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
}