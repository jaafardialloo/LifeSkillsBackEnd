package Training.LifeSkills.security.config;

import Training.LifeSkills.security.filter.ApiKeyFilter;
import Training.LifeSkills.security.provider.JWTProvider;
import Training.LifeSkills.security.service.JWTUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

  private final JWTUserDetailsService jwtUserDetailsService;
  private final JWTProvider provider;
  @Value("${secret.api.key}")
  private String key;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity.
            csrf()
            .disable()
            .authorizeHttpRequests()
            .anyRequest()
            .authenticated()
            .and()
            .addFilterBefore(new ApiKeyFilter(key), UsernamePasswordAuthenticationFilter.class)
            .build();

  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
