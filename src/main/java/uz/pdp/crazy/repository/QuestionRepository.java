package uz.pdp.crazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.crazy.entity.QuestionEntity;
import uz.pdp.crazy.entity.TopicEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {
    Optional<QuestionEntity> findByName(String name);
    List<QuestionEntity> findAllByTopicEntity(TopicEntity topicEntity);
    void deleteById(Long id);
}
