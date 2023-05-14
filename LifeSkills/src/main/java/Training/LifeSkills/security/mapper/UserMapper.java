package Training.LifeSkills.security.mapper;


import Training.LifeSkills.security.dto.UserDTO;
import Training.LifeSkills.security.entity.User;
import org.mapstruct.Builder;

@org.mapstruct.Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UserMapper extends
    Mapper<User, UserDTO> {

  //@Mapping(target = "password", ignore = true)
  //@Mapping(target = "resetToken", ignore = true)
  //@Mapping(target = "resetToken", ignore = true)
  UserDTO toDto(User model);

  @Override
  default Class<User> getModelClass() {
    return User.class;
  }

}
