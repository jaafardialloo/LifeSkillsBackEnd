package Training.LifeSkills.security.service;


import Training.LifeSkills.security.dto.UserDTO;
import Training.LifeSkills.security.entity.Role;
import Training.LifeSkills.security.entity.User;
import Training.LifeSkills.security.enumeration.RoleEnum;
import Training.LifeSkills.security.mapper.UserMapper;
import Training.LifeSkills.security.repository.RoleRepository;
import Training.LifeSkills.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final RoleRepository roleRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;


  public UserDTO save(UserDTO userDTO) {
    User user = userMapper.toModel(userDTO);
    RoleEnum role = Objects.nonNull(user.getRoleEnum()) ? RoleEnum.valueOf(user.getRoleEnum().name()) : RoleEnum.ADMIN;
    user.setRoleEnum(role);
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setIsActive(false);
    return userMapper.toDto(userRepository.save(user));
  }

  public List<UserDTO> findAll() {
    return userMapper.toDtos(userRepository.findAll());
  }

  public UserDTO getConnectedUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null) {
      String name = authentication.getName();
      return userMapper.toDto(userRepository.findByUsername(name).orElse(null));
    }
    return null;
  }

  public UserDTO findByUsername(String username) {
    return userMapper.toDto(userRepository.findByUsername(username).orElse(null));
  }

  public void activateUsers(Set<Long> ids) {
    patchIsActive(ids,true);
  }

  public void deactivateUsers(Set<Long> ids) {
    patchIsActive(ids,false);
  }

  private void patchIsActive(Set<Long> ids, boolean isActive) {
    List<User> users = userRepository.findAllById(ids);
    if (!CollectionUtils.isEmpty(users)) {
      users.forEach(user -> user.setIsActive(isActive));
      userRepository.saveAll(users);
    }
  }

  public void addRoles(Long userId, Set<Long> roleIds) {
    userRepository.findById(userId).ifPresent(user -> {
      if (!CollectionUtils.isEmpty(roleIds)) {
        List<Role> roles = roleRepository.findAllById(roleIds);
        if (!CollectionUtils.isEmpty(roles)) {
          user.getRoles().addAll(roles);
          userRepository.save(user);
        }
      }
    });
  }

  public void removeRoles(Long userId, Set<Long> roleIds) {
    userRepository.findById(userId).ifPresent(user -> {
      if (!CollectionUtils.isEmpty(roleIds)) {
        Set<Role> roles = new HashSet<>();
        for (Role role : user.getRoles()) {
          if (!roleIds.contains(role.getId())) {
            roles.add(role);
          }
        }
        user.setRoles(roles);
        userRepository.save(user);
      }
    });
  }

  public List<UserDTO> findAllByUserRole(String userRole) {
    RoleEnum roleEnum = RoleEnum.valueOf(userRole);
    return userMapper.toDtos(userRepository.findAllByRoleEnum(roleEnum));
  }

  public boolean deleteUserById(Long userId) {

    userRepository.deleteById(userId);
    return true;
  }
}
