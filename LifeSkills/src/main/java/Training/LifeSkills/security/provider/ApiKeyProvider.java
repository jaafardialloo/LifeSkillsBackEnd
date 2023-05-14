package Training.LifeSkills.security.provider;

import Training.LifeSkills.security.authentication.ApiKeyAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@RequiredArgsConstructor
public class ApiKeyProvider implements AuthenticationProvider {

  private final String key;
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    ApiKeyAuthentication apiKeyAuthentication = (ApiKeyAuthentication) authentication;
    if (key.equals(apiKeyAuthentication.getKey())) {
      apiKeyAuthentication.setAuthenticated(true);
      return apiKeyAuthentication;
    }
    throw new BadCredentialsException(":(");
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return ApiKeyAuthentication.class.equals(authentication);
  }
}
