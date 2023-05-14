package Training.LifeSkills.security.provider;


import Training.LifeSkills.security.authentication.JWTAuthentication;
import Training.LifeSkills.security.service.JWTUserDetailsService;
import Training.LifeSkills.security.userDetails.JWTUserDetails;
import Training.LifeSkills.security.utils.JwtUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class JWTProvider implements AuthenticationProvider {

  private final JWTUserDetailsService jwtUserDetailsService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    JWTAuthentication jwtAuthentication = (JWTAuthentication) authentication;
    DecodedJWT decodedJWT = JwtUtil.verifyToken(jwtAuthentication.getToken());
    if (decodedJWT != null) {
      Instant exp = decodedJWT.getClaims().get("exp").asInstant();
      if (exp.isAfter(Instant.now())) {
        String sub = decodedJWT.getClaims().get("sub").asString();
        if (StringUtils.hasLength(sub)) {
          JWTUserDetails customUserDetails = (JWTUserDetails) jwtUserDetailsService.loadUserByUsername(
              sub);
          jwtAuthentication.setAuthorities(customUserDetails.getAuthorities());
          jwtAuthentication.setAuthenticated(true);
        }
      }
    }
    return jwtAuthentication;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return JWTAuthentication.class.equals(authentication);
  }
}
