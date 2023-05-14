package Training.LifeSkills.security.service;


import Training.LifeSkills.security.dto.AuthRequestDTO;
import Training.LifeSkills.security.dto.AuthResponseDTO;
import Training.LifeSkills.security.dto.UserDTO;
import Training.LifeSkills.security.entity.User;
import Training.LifeSkills.security.mapper.UserMapper;
import Training.LifeSkills.security.repository.UserRepository;
import Training.LifeSkills.security.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository repository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  public ResponseEntity<Object> login(AuthRequestDTO authRequest) {
    Optional<User> optionalUser = repository.findByUsername(authRequest.getUsername());
    if (optionalUser.isPresent() && isUserValid(optionalUser.get(), authRequest.getPassword())) {
      try {
        String token = JwtUtil.createToken(optionalUser.get().getUsername(), false, true);
        UserDTO userDTO = userMapper.toDto(optionalUser.get());
        AuthResponseDTO authResponse = AuthResponseDTO.builder()
            .accessToken(token)
            .user(userDTO).build();
        return ResponseEntity.status(HttpStatus.OK).body(authResponse);
      } catch (Exception e) {
        log.error("token generation failed", e);
        throw new RuntimeException(e);
      }
    }
    return ResponseEntity
        .status(HttpStatus.FORBIDDEN)
        .body("log in failed, bad credentials");
  }

  private boolean isUserValid(User user, String password) {
    return passwordEncoder.matches(password, user.getPassword());
  }
}
