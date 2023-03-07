package uz.pdp.crazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.crazy.entity.AttachmentEntity;


public interface AttachmentRepository extends JpaRepository<AttachmentEntity,Long> {
}
