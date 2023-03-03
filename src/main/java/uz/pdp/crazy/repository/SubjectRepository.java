package uz.pdp.crazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.crazy.entity.SubjectEntity;

public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
}
