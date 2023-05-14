package Training.LifeSkills.security.mapper;


import Training.LifeSkills.security.dto.RoleDTO;
import Training.LifeSkills.security.entity.Role;
import org.mapstruct.Builder;

@org.mapstruct.Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface RoleMapper extends
    Mapper<Role, RoleDTO> {

  @Override
  default Class<Role> getModelClass() {
    return Role.class;
  }

}
