package Training.LifeSkills.security.service;


import Training.LifeSkills.security.dto.RoleDTO;
import Training.LifeSkills.security.mapper.RoleMapper;
import Training.LifeSkills.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

  private final RoleRepository roleRepository;
  private final RoleMapper roleMapper;


  public RoleDTO save(RoleDTO roleDTO) {
    return roleMapper.toDto(roleRepository.save(roleMapper.toModel(roleDTO)));
  }


  public List<RoleDTO> findAll() {
    return roleMapper.toDtos(roleRepository.findAll());
  }
}
