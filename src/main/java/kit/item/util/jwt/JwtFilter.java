package kit.item.util.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kit.item.repository.h2.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {
   private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);
   public static final String ACCESS_TOKEN = "ACCESS-TOKEN";
   public static final String REFRESH_TOKEN = "REFRESH-TOKEN";
   public static final String AUTHORIZATION = "Bearer ";
   private final TokenProvider tokenProvider;

   @Override
   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
      String accessToken = resolveAccessToken(httpServletRequest);
      String refreshToken = resolveRefreshToken(httpServletRequest);
      String requestURI = httpServletRequest.getRequestURI();
      Authentication authentication = null;

      try{
         if(tokenProvider.validateToken(accessToken)) {
            // accessToken 검증 통과
            authentication = tokenProvider.getAuthentication(accessToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            logger.debug("Security Context에 '{}' 인증 정보를 저장했습니다, uri: {}", authentication.getName(), requestURI);
         }else{
            // accessToken 검증 미통과
            logger.debug("유효한 JWT 토큰이 없습니다, uri: {}", requestURI);
         }
      }catch (ExpiredJwtException accessError) {
         logger.debug("JWT 토큰 만료 : {}", accessError.getMessage());

         // 2. refreshToken 검증
         try{
            if(tokenProvider.validateToken(refreshToken)) {
               // refreshToken 검증 통과 && accessToken 새로 생성
               logger.debug("AccessToken 생성");
               authentication = tokenProvider.getAuthentication(refreshToken);
               SecurityContextHolder.getContext().setAuthentication(authentication);
               logger.debug("Security Context에 '{}' 인증 정보를 저장했습니다, uri: {}", authentication.getName(), requestURI);
               accessToken = tokenProvider.createAccessToken(authentication);
               HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
               httpServletResponse.addHeader(ACCESS_TOKEN, AUTHORIZATION + accessToken);
            }else{
               // refreshToken 검증 미통과
               logger.debug("RefreshToken 에러: {}", requestURI);
            }
         }catch (ExpiredJwtException refreshError) {
            // refreshToken 만료
            logger.debug("RefreshToken 만료: {}", requestURI);
         }
      }



      filterChain.doFilter(servletRequest, servletResponse);
   }

   private String resolveAccessToken(HttpServletRequest request) {
      String bearerToken = request.getHeader(ACCESS_TOKEN);
      if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
         return bearerToken.substring(7);
      }
      return null;
   }

   private String resolveRefreshToken(HttpServletRequest request) {
      String bearerToken = request.getHeader(REFRESH_TOKEN);
      if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
         return bearerToken.substring(7);
      }
      return null;
   }
}
