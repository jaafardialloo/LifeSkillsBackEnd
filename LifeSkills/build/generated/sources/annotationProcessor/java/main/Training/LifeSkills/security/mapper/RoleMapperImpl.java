package Training.LifeSkills.security.mapper;

import Training.LifeSkills.security.dto.AuthorityDTO;
import Training.LifeSkills.security.dto.RoleDTO;
import Training.LifeSkills.security.entity.Authority;
import Training.LifeSkills.security.entity.Role;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-14T17:29:14+0000",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 13.0.14 (Azul Systems, Inc.)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toModel(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( dto.getId() );
        role.setName( dto.getName() );
        role.setAuthorities( authorityDTOSetToAuthoritySet( dto.getAuthorities() ) );

        return role;
    }

    @Override
    public RoleDTO toDto(Role model) {
        if ( model == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( model.getId() );
        roleDTO.setName( model.getName() );
        roleDTO.setAuthorities( authoritySetToAuthorityDTOSet( model.getAuthorities() ) );

        return roleDTO;
    }

    @Override
    public List<Role> toModels(List<RoleDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( dtos.size() );
        for ( RoleDTO roleDTO : dtos ) {
            list.add( toModel( roleDTO ) );
        }

        return list;
    }

    @Override
    public List<RoleDTO> toDtos(List<Role> models) {
        if ( models == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( models.size() );
        for ( Role role : models ) {
            list.add( toDto( role ) );
        }

        return list;
    }

    protected Authority authorityDTOToAuthority(AuthorityDTO authorityDTO) {
        if ( authorityDTO == null ) {
            return null;
        }

        Authority authority = new Authority();

        authority.setId( authorityDTO.getId() );
        authority.setName( authorityDTO.getName() );

        return authority;
    }

    protected Set<Authority> authorityDTOSetToAuthoritySet(Set<AuthorityDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Authority> set1 = new LinkedHashSet<Authority>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AuthorityDTO authorityDTO : set ) {
            set1.add( authorityDTOToAuthority( authorityDTO ) );
        }

        return set1;
    }

    protected AuthorityDTO authorityToAuthorityDTO(Authority authority) {
        if ( authority == null ) {
            return null;
        }

        AuthorityDTO authorityDTO = new AuthorityDTO();

        authorityDTO.setId( authority.getId() );
        authorityDTO.setName( authority.getName() );

        return authorityDTO;
    }

    protected Set<AuthorityDTO> authoritySetToAuthorityDTOSet(Set<Authority> set) {
        if ( set == null ) {
            return null;
        }

        Set<AuthorityDTO> set1 = new LinkedHashSet<AuthorityDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Authority authority : set ) {
            set1.add( authorityToAuthorityDTO( authority ) );
        }

        return set1;
    }
}
