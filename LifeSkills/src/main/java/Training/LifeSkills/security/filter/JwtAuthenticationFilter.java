package Training.LifeSkills.security.filter;


import Training.LifeSkills.security.authentication.JWTAuthentication;
import Training.LifeSkills.security.manager.JWTAuthenticationManager;
import Training.LifeSkills.security.service.JWTUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {


  private final JWTUserDetailsService jwtUserDetailsService;

  public JwtAuthenticationFilter(JWTUserDetailsService jwtUserDetailsService) {
    this.jwtUserDetailsService = jwtUserDetailsService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {

    if (SecurityContextHolder.getContext() != null
        && SecurityContextHolder.getContext().getAuthentication()
        != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
      filterChain.doFilter(request, response);
      return;
    }

    JWTAuthenticationManager jwtAuthenticationManager = new JWTAuthenticationManager(
        jwtUserDetailsService);

    String authorizationHeader = request.getHeader("Authorization");
    if (StringUtils.hasLength(authorizationHeader)) {
      String token = authorizationHeader.replace("Bearer ", "");
      JWTAuthentication auth = new JWTAuthentication(token);
      try {
        Authentication a = jwtAuthenticationManager.authenticate(auth);
        if (a.isAuthenticated()) {
          SecurityContextHolder.getContext().setAuthentication(a);
          filterChain.doFilter(request, response);
        }
      } catch (Exception ignored) {
      }
    }


  }
}
