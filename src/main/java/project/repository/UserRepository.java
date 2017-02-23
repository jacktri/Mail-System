package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.entity.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>
{

    List<UserEntity> findByUsername(String username);
}
