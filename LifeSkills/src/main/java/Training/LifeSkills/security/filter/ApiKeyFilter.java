package Training.LifeSkills.security.filter;


import Training.LifeSkills.security.authentication.ApiKeyAuthentication;
import Training.LifeSkills.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

  private final String key;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {

    filterChain.doFilter(request, response);

    if (SecurityContextHolder.getContext() != null
        && SecurityContextHolder.getContext().getAuthentication()
        != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
      return;
    }

    CustomAuthenticationManager customAuthenticationManager = new CustomAuthenticationManager(key);

    String headerKey = request.getHeader("x-api-key");
    ApiKeyAuthentication auth = new ApiKeyAuthentication(headerKey);

    try {
      Authentication a = customAuthenticationManager.authenticate(auth);
      if (a.isAuthenticated()) {
        SecurityContextHolder.getContext().setAuthentication(a);
        filterChain.doFilter(request, response);
      } else {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      }
    } catch (Exception exception) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

  }
}
