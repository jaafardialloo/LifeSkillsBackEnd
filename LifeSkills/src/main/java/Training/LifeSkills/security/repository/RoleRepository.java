package Training.LifeSkills.security.repository;

import Training.LifeSkills.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
     Role findRoleByName(String name);
}
