package uz.pdp.crazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.crazy.entity.UserEntity;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByPhone(String username);
    Optional<UserEntity> findByEmail(String username);
     void deleteById(Long id);
}
