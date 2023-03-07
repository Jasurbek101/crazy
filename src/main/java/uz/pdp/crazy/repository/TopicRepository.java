package uz.pdp.crazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.crazy.entity.TopicEntity;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<TopicEntity,Long> {
    Optional<TopicEntity> findById(Long id);
    Optional<TopicEntity> findByName(String name);
    List<TopicEntity> findAll();
    void deleteById(Long id);

}
