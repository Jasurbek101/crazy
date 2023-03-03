package uz.pdp.crazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.crazy.entity.Avatar;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar,Long> {
}
