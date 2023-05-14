package Training.LifeSkills.security.manager;

import Training.LifeSkills.security.provider.JWTProvider;
import Training.LifeSkills.security.service.JWTUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@RequiredArgsConstructor
public class JWTAuthenticationManager implements AuthenticationManager {

  private final JWTUserDetailsService jwtUserDetailsService;



  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    JWTProvider provider = new JWTProvider(jwtUserDetailsService);
    if (provider.supports(authentication.getClass())) {
      return provider.authenticate(authentication);
    }
    return authentication;
  }
}
