package uz.pdp.crazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.crazy.entity.AvatarEntity;


public interface AvatarRepository extends JpaRepository<AvatarEntity,Long> {
}
