package kit.item.util.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {
   private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);
   public static final String ACCESS_TOKEN = "ACCESS-TOKEN";
   public static final String X_AUTH_TOKEN = "X-AUTH-TOKEN";
   public static final String MEMBER_ID = "MEMBER_ID";
   public static final String AUTHORIZATION = "Bearer ";
   private final TokenProvider tokenProvider;

   @Override
   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
      String accessToken = resolveToken(httpServletRequest);
      String requestURI = httpServletRequest.getRequestURI();
      Authentication authentication = null;

      if(tokenProvider.validateToken(accessToken)) {
         // accessToken 검증 통과
         authentication = tokenProvider.getAuthentication(accessToken);
         SecurityContextHolder.getContext().setAuthentication(authentication);
         logger.debug("Security Context에 '{}' 인증 정보를 저장했습니다, uri: {}", authentication.getName(), requestURI);
      }
      filterChain.doFilter(servletRequest, servletResponse);
   }

   private String resolveToken(HttpServletRequest request) {
      String bearerToken = request.getHeader(X_AUTH_TOKEN);
      if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(AUTHORIZATION)) {
         return bearerToken.substring(7);
      }
      return null;
   }
}
