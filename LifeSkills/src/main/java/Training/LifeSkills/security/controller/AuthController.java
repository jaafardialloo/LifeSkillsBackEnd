package Training.LifeSkills.security.controller;

import Training.LifeSkills.security.dto.AuthRequestDTO;
import Training.LifeSkills.security.service.AuthService;
import Training.LifeSkills.security.utils.JwtUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AuthController {

  private final AuthService authService;

  private final PasswordEncoder passwordEncoder;

  @GetMapping
  public void test() {

    AuthRequestDTO nebil = AuthRequestDTO.builder()
        .password("12345")
        .username("nebil")
        .rememberMe(false).build();
   // authService.login(nebil);
    int i = 10;
    String token = JwtUtil.createToken("nebil",false,false);
    DecodedJWT decodedJWT = JwtUtil.verifyToken(token);
    if (decodedJWT != null) {
      Instant exp = decodedJWT.getClaims().get("exp").asInstant();
      if (exp.isBefore(Instant.now())) {
        String sub = decodedJWT.getClaims().get("sub").asString();
        if (StringUtils.hasLength(sub)) {
          log.info("loading user by username");
          // load user by username
        }
      }
    }
  }

  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody AuthRequestDTO authRequest) {
    return authService.login(authRequest);
  }

}
