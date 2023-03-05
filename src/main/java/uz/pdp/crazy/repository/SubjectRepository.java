package uz.pdp.crazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.crazy.entity.SubjectEntity;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
    Optional<SubjectEntity> findByTitle(String title);
    List<SubjectEntity> findAll();
    void deleteById(Long id);
}
