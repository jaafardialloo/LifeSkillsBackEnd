package Training.LifeSkills.security.mapper;


import Training.LifeSkills.security.dto.AuthorityDTO;
import Training.LifeSkills.security.entity.Authority;
import org.mapstruct.Builder;

@org.mapstruct.Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AuthorityMapper extends
        Mapper<Authority, AuthorityDTO> {

  @Override
  default Class<Authority> getModelClass() {
    return Authority.class;
  }

}
