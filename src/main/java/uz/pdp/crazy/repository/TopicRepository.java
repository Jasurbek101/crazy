package uz.pdp.crazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.crazy.entity.TopicEntity;

public interface TopicRepository extends JpaRepository<TopicEntity,Long> {

}
