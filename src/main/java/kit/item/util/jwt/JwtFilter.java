package kit.item.util.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

import static kit.item.util.prefix.ConstPrefix.*;

@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {
   private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

   private final TokenProvider tokenProvider;

   @Override
   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
      HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
      String accessToken = resolveToken(httpServletRequest);
      String requestURI = httpServletRequest.getRequestURI();
      Authentication authentication = null;

      if (tokenProvider.validateToken(accessToken)) {
         // accessToken 검증 통과
         authentication = tokenProvider.getAuthentication(accessToken);
         SecurityContextHolder.getContext().setAuthentication(authentication);
         logger.debug("Security Context에 '{}' 인증 정보를 저장했습니다, uri: {}", authentication.getName(), requestURI);
      }
      filterChain.doFilter(httpServletRequest, servletResponse);
   }

   private String resolveToken(HttpServletRequest request) {
      String bearerToken = request.getHeader(X_AUTH_TOKEN);
      if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(AUTHORIZATION)) {
         return bearerToken.substring(7);
      }
      return null;
   }
}
