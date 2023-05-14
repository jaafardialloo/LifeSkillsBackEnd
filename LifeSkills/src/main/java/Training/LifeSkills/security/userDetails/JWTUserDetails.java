package Training.LifeSkills.security.userDetails;


import Training.LifeSkills.security.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JWTUserDetails implements UserDetails {

  private final User user;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();

    if (user == null) {
      return Collections.emptyList();
    }

    Set<String> grantedAuthorities = user.listGrantedAuthorities();
    if (!CollectionUtils.isEmpty(grantedAuthorities)) {
      return user.listGrantedAuthorities().stream().map(SimpleGrantedAuthority::new)
          .collect(Collectors.toList());
    }

    return authorities;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return user.getIsActive();
  }
}
