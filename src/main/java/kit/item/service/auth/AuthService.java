package kit.item.service.auth;

import kit.item.domain.h2.RefreshToken;
import kit.item.dto.request.auth.RequestLoginDto;
import kit.item.dto.request.auth.RequestLogoutDto;
import kit.item.dto.request.auth.RequestReissueDto;
import kit.item.dto.request.auth.RequestSignupDto;
import kit.item.dto.response.auth.ResponseLoginDto;
import kit.item.dto.response.auth.ResponseLogoutDto;
import kit.item.dto.response.auth.ResponseReissueDto;
import kit.item.dto.response.auth.ResponseSignupDto;
import kit.item.repository.h2.RefreshTokenRepository;
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
    private final RefreshTokenRepository refreshTokenRepository;
    private final MemberService memberService;


    @Transactional
    public ResponseSignupDto signup(RequestSignupDto requestSignupDto) {
        return memberService.signup(requestSignupDto);
    }

    @Transactional
    public ResponseLoginDto login(RequestLoginDto requestLoginDto) throws RuntimeException {
        // 1. Login Email/PW 를 기반으로 AuthenticationToken 생성
        //UsernamePasswordAuthenticationToken authenticationToken = requestLoginDto.toAuthentication();
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(requestLoginDto.getEmail(), requestLoginDto.getPassword());

        // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
        //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        String accessToken = tokenProvider.createAccessToken(authentication);
        String refreshToken = tokenProvider.createRefreshToken(authentication);

        if(refreshTokenRepository.existsByEmail(authentication.getName())){
            // 4-1. 기존 RefreshToken에 저장
            Optional<RefreshToken> getRefreshToken = refreshTokenRepository.findByEmail(authentication.getName());
            if(getRefreshToken.isPresent()){
                getRefreshToken.get().setToken(refreshToken);
                refreshTokenRepository.save(getRefreshToken.get());
            }
        }else{
            // 4-2. 새로운 RefreshToken 저장
            refreshTokenRepository.save(RefreshToken.builder()
                    .email(authentication.getName())
                    .token(refreshToken)
                    .build());
        }

        // 5. 토큰 발급
        return ResponseLoginDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Transactional
    public void logout(RequestLogoutDto requestLogoutDto) {
        // 1. Refresh Token 검증
        if (!tokenProvider.validateToken(requestLogoutDto.getRefreshToken())) {
            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
        }

        // 2. Refresh Token 에서 Member Email 가져오기
        Authentication authentication = tokenProvider.getAuthentication(requestLogoutDto.getRefreshToken());

        // 3. 저장소에서 Member Email 를 기반으로 Refresh Token 값 가져옴
        RefreshToken refreshToken = refreshTokenRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new RuntimeException("로그아웃 된 사용자입니다."));

        // 4. Refresh Token 일치하는지 검사
        if (!refreshToken.getToken().equals(requestLogoutDto.getRefreshToken())) {
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        refreshToken.setToken("");
        refreshTokenRepository.save(refreshToken);
    }

//    @Transactional
//    public ResponseReissueDto reissue(RequestReissueDto requestReissueDto) {
//        // 1. Refresh Token 검증
//        if (!tokenProvider.validateToken(requestReissueDto.getRefreshToken())) {
//            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
//        }
//
//        // 2. Refresh Token 에서 Member Email 가져오기
//        Authentication authentication = tokenProvider.getAuthentication(requestReissueDto.getRefreshToken());
//
//        // 3. 저장소에서 Member Email 를 기반으로 Refresh Token 값 가져옴
//        RefreshToken refreshToken = refreshTokenRepository.findByEmail(authentication.getName())
//                .orElseThrow(() -> new RuntimeException("로그아웃 된 사용자입니다."));
//
//        // 4. Refresh Token 일치하는지 검사
//        if (!refreshToken.getToken().equals(requestReissueDto.getRefreshToken())) {
//            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
//        }
//
//        // 5. 새로운 토큰 생성
//        String accessToken = tokenProvider.createAccessToken(authentication);
//        String newRefreshToken = tokenProvider.createRefreshToken(authentication);
//        refreshToken.setToken(newRefreshToken);
//        refreshTokenRepository.save(refreshToken);
//
//        // 토큰 발급
//        return ResponseReissueDto.builder()
//                .accessToken(accessToken)
//                .refreshToken(newRefreshToken)
//                .build();
//    }
}
