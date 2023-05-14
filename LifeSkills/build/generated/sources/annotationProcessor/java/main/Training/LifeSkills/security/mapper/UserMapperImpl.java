package Training.LifeSkills.security.mapper;

import Training.LifeSkills.security.dto.UserDTO;
import Training.LifeSkills.security.entity.User;
import Training.LifeSkills.security.enumeration.RoleEnum;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-14T17:29:14+0000",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 13.0.14 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toModel(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setNni( dto.getNni() );
        user.setTel( dto.getTel() );
        user.setName( dto.getName() );
        user.setEmail( dto.getEmail() );
        user.setUsername( dto.getUsername() );
        user.setPassword( dto.getPassword() );
        user.setResetToken( dto.getResetToken() );
        user.setIsDeleted( dto.getIsDeleted() );
        user.setIsActive( dto.getIsActive() );
        user.setIsVerified( dto.getIsVerified() );
        user.setIsTmpPassword( dto.getIsTmpPassword() );
        user.setVerificationCode( dto.getVerificationCode() );
        if ( dto.getRoleEnum() != null ) {
            user.setRoleEnum( Enum.valueOf( RoleEnum.class, dto.getRoleEnum() ) );
        }

        return user;
    }

    @Override
    public List<User> toModels(List<UserDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtos.size() );
        for ( UserDTO userDTO : dtos ) {
            list.add( toModel( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toDtos(List<User> models) {
        if ( models == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( models.size() );
        for ( User user : models ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public UserDTO toDto(User model) {
        if ( model == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( model.getId() );
        userDTO.setTel( model.getTel() );
        userDTO.setNni( model.getNni() );
        userDTO.setUsername( model.getUsername() );
        userDTO.setEmail( model.getEmail() );
        userDTO.setName( model.getName() );
        userDTO.setPassword( model.getPassword() );
        userDTO.setResetToken( model.getResetToken() );
        userDTO.setVerificationCode( model.getVerificationCode() );
        userDTO.setIsDeleted( model.getIsDeleted() );
        userDTO.setIsActive( model.getIsActive() );
        userDTO.setIsVerified( model.getIsVerified() );
        userDTO.setIsTmpPassword( model.getIsTmpPassword() );
        if ( model.getRoleEnum() != null ) {
            userDTO.setRoleEnum( model.getRoleEnum().name() );
        }

        return userDTO;
    }
}
