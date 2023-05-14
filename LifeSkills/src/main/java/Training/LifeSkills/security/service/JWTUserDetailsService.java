package Training.LifeSkills.security.service;


import Training.LifeSkills.security.entity.User;
import Training.LifeSkills.security.repository.UserRepository;
import Training.LifeSkills.security.userDetails.JWTUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@RequiredArgsConstructor
@Component
public class JWTUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> optionalUser = userRepository.findByUsername(username);
    return optionalUser.map(JWTUserDetails::new).orElseThrow(() -> {
      throw new UsernameNotFoundException("user not found");
    });
  }
}
