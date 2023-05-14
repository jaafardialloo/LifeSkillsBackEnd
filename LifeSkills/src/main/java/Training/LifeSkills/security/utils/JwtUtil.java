package Training.LifeSkills.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Slf4j
public class JwtUtil {

  public static final String SECRET = "dRHZDWSQGwrcePxSP9gt9wbsaWhbn6bE7LzcMjgnKdx3SetNSqV9mawTgwHgoowStFBPFcoDE5dnmMrs";
  public static final long EXPIRATION_TIME = 1L; // 1 hour
  public static final long EXPIRATION_TIME_REFRESH = 2L; // 2 hours
  public static final long EXPIRATION_TIME_REMEMBER_ME = 24L; // 24 hours

  public static String createToken(String username, boolean isRefresh, boolean isRememberMe) {
    try {
      log.info("[createToken] start generating a new token");
      Algorithm algorithm = Algorithm.HMAC512(SECRET);
      String token = JWT.create()
          .withIssuer("ibtikar")
          .withSubject(username)
          .withIssuedAt(Instant.now())
          .withNotBefore(Instant.now())
          .withExpiresAt(Instant.now().plus(isRefresh ? EXPIRATION_TIME_REFRESH
                  : isRememberMe ? EXPIRATION_TIME_REMEMBER_ME : EXPIRATION_TIME,
              ChronoUnit.HOURS))
          .sign(algorithm);
      log.info("[createToken] token generated successfully: {}", token);
      return token;
    } catch (JWTCreationException e) {
      log.error("[createToken] token generation failed", e);
      throw new RuntimeException(e);
    }
  }

  public static DecodedJWT verifyToken(String token) {
    DecodedJWT decodedJWT;
    try {
      Algorithm algorithm = Algorithm.HMAC512(SECRET);
      JWTVerifier verifier = JWT.require(algorithm)
          .withIssuer("ibtikar")
          .build();
      return verifier.verify(token);
    } catch (JWTVerificationException e) {
      throw new RuntimeException(e);
    }
  }
}
