package uz.pdp.crazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.crazy.entity.VideoEntity;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity,Long> {
   void deleteById(Long id);
}