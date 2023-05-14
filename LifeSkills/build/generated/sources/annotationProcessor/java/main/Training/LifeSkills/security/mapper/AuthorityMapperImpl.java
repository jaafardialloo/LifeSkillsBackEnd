package Training.LifeSkills.security.mapper;

import Training.LifeSkills.security.dto.AuthorityDTO;
import Training.LifeSkills.security.entity.Authority;
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
public class AuthorityMapperImpl implements AuthorityMapper {

    @Override
    public Authority toModel(AuthorityDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Authority authority = new Authority();

        authority.setId( dto.getId() );
        authority.setName( dto.getName() );

        return authority;
    }

    @Override
    public AuthorityDTO toDto(Authority model) {
        if ( model == null ) {
            return null;
        }

        AuthorityDTO authorityDTO = new AuthorityDTO();

        authorityDTO.setId( model.getId() );
        authorityDTO.setName( model.getName() );

        return authorityDTO;
    }

    @Override
    public List<Authority> toModels(List<AuthorityDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Authority> list = new ArrayList<Authority>( dtos.size() );
        for ( AuthorityDTO authorityDTO : dtos ) {
            list.add( toModel( authorityDTO ) );
        }

        return list;
    }

    @Override
    public List<AuthorityDTO> toDtos(List<Authority> models) {
        if ( models == null ) {
            return null;
        }

        List<AuthorityDTO> list = new ArrayList<AuthorityDTO>( models.size() );
        for ( Authority authority : models ) {
            list.add( toDto( authority ) );
        }

        return list;
    }
}
