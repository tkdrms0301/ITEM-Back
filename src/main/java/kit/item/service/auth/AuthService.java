package kit.item.service.auth;

import kit.item.dto.request.auth.RequestLoginDto;
import kit.item.dto.request.auth.RequestLogoutDto;
import kit.item.dto.request.auth.RequestReissueDto;
import kit.item.dto.request.auth.RequestSignupDto;
import kit.item.dto.response.auth.ResponseLoginDto;
import kit.item.dto.response.auth.ResponseLogoutDto;
import kit.item.dto.response.auth.ResponseReissueDto;
import kit.item.dto.response.auth.ResponseSignupDto;
import kit.item.service.member.MemberService;
import kit.item.util.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final MemberService memberService;


    @Transactional
    public ResponseSignupDto signup(RequestSignupDto requestSignupDto) {
        return memberService.signup(requestSignupDto);
    }

    @Transactional
    public ResponseLoginDto login(RequestLoginDto requestLoginDto) throws RuntimeException {
        // 1. Login Email/PW 를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(requestLoginDto.getEmail(), requestLoginDto.getPassword());

        // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
        //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        String accessToken = tokenProvider.createToken(authentication);

        // 5. 토큰 발급
        return ResponseLoginDto.builder()
                .accessToken(accessToken)
                .build();
    }
}
