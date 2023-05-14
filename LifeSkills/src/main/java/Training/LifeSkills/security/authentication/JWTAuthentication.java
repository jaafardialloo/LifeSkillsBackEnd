package Training.LifeSkills.security.authentication;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@RequiredArgsConstructor
public class JWTAuthentication implements Authentication {

  private final String token;
  private boolean authenticated;
  private Collection<? extends GrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;

  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getDetails() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return null;
  }

  @Override
  public boolean isAuthenticated() {
    return this.authenticated;
  }

  @Override
  public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
    this.authenticated = authenticated;

  }

  @Override
  public String getName() {
    return null;
  }
}
