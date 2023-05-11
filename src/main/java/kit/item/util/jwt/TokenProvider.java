package kit.item.util.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
@PropertySource("classpath:jwt/jwt.properties")
public class TokenProvider implements InitializingBean {

   private final Logger logger = LoggerFactory.getLogger(TokenProvider.class);
   private static final String ROLE_TYPE = "roleType";
   private static final String CREATION_TIME = "start";
   private final String secret;
   private final long accessTokenValidityInMilliseconds;
   private final long refreshTokenValidityInMilliseconds;
   private Key key;

   public TokenProvider(
      @Value("${jwt.secret}") String secret,
      @Value("${jwt.access-token-validity-in-seconds}") long accessTokenValidityInMilliseconds,
      @Value("${jwt.refresh-token-validity-in-seconds}") long refreshTokenValidityInMilliseconds) {
      this.secret = secret;
      this.accessTokenValidityInMilliseconds = accessTokenValidityInMilliseconds * 1000;
      this.refreshTokenValidityInMilliseconds = refreshTokenValidityInMilliseconds * 1000;
   }

   @Override
   public void afterPropertiesSet() {
      byte[] keyBytes = Decoders.BASE64.decode(secret);
      this.key = Keys.hmacShaKeyFor(keyBytes);
   }

   public String createToken(Authentication authentication) {
      String authorities = authentication.getAuthorities().stream()
         .map(GrantedAuthority::getAuthority)
         .collect(Collectors.joining(","));

      long now = (new Date()).getTime();
      Date validity = new Date(now + this.accessTokenValidityInMilliseconds);

      return Jwts.builder()
         .setSubject(authentication.getName())
         .claim(ROLE_TYPE, authorities)
         .claim(CREATION_TIME, LocalDateTime.now().toString())
         .signWith(key, SignatureAlgorithm.HS512)
         .setExpiration(validity)
         .compact();
   }

   public String createRefreshToken(Authentication authentication) {
      String authorities = authentication.getAuthorities().
              stream()
              .map(GrantedAuthority::getAuthority)
              .collect(Collectors.joining(","));

      long now = (new Date()).getTime();
      Date validity = new Date(now + this.refreshTokenValidityInMilliseconds);

      return Jwts.builder()
              .setSubject(authentication.getName())
              .claim(ROLE_TYPE, authorities)
              .claim(CREATION_TIME, LocalDateTime.now().toString())
              .signWith(key, SignatureAlgorithm.HS512)
              .setExpiration(validity)
              .compact();
   }

   public Authentication getAuthentication(String token) {
      Claims claims = Jwts
              .parserBuilder()
              .setSigningKey(key)
              .build()
              .parseClaimsJws(token)
              .getBody();

      Collection<? extends GrantedAuthority> authorities =
         Arrays.stream(claims.get(ROLE_TYPE).toString().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

      User principal = new User(claims.getSubject(), "", authorities);

      return new UsernamePasswordAuthenticationToken(principal, token, authorities);
   }

   public boolean validateToken(String token) throws ExpiredJwtException {
      try {
         Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
         return true;
      } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
         logger.info("잘못된 JWT 서명입니다.");
      } catch (ExpiredJwtException e){
         logger.info("만료된 JWT 토큰입니다.");
      } catch (UnsupportedJwtException e) {
         logger.info("지원되지 않는 JWT 토큰입니다.");
      } catch (IllegalArgumentException e) {
         logger.info("JWT 토큰이 잘못되었습니다.");
      }
      return false;
   }
}
