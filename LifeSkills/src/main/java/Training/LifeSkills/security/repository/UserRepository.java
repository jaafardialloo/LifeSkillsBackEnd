package Training.LifeSkills.security.repository;


import Training.LifeSkills.security.entity.User;
import Training.LifeSkills.security.enumeration.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByNni(String username);

    List<User> findAllByRoleEnum(RoleEnum roleEnum);
}
