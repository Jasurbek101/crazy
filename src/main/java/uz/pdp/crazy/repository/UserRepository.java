package uz.pdp.crazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.crazy.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
