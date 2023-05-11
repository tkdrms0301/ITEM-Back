package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.request.auth.RequestLoginDto;
import kit.item.dto.request.auth.RequestLogoutDto;
import kit.item.dto.request.auth.RequestReissueDto;
import kit.item.dto.request.auth.RequestSignupDto;
import kit.item.dto.response.auth.ResponseLoginDto;
import kit.item.dto.response.auth.ResponseLogoutDto;
import kit.item.dto.response.auth.ResponseReissueDto;
import kit.item.dto.response.auth.ResponseSignupDto;
import kit.item.dto.response.member.ResponseLoginMemberDto;
import kit.item.exception.DuplicateMemberException;
import kit.item.service.auth.AuthService;
import kit.item.service.member.MemberService;
import kit.item.util.jwt.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final MemberService memberService;
    private final static String HEADER = "Bearer ";

    @PostMapping("/signup")
    public ResponseEntity<MsgDto> signup(@RequestBody RequestSignupDto requestSignupDto) {
        ResponseSignupDto responseSignupDto;
        try{
            responseSignupDto = authService.signup(requestSignupDto);
        }catch (DuplicateMemberException e) {
            return ResponseEntity.ok(new MsgDto(false, e.getMessage(), null));
        }
        return ResponseEntity.ok(new MsgDto(true, "회원가입 성공", responseSignupDto));
    }

    @PostMapping("/login")
    public ResponseEntity<MsgDto> login(@RequestBody RequestLoginDto requestLoginDto) {
        ResponseLoginDto responseLoginDto = authService.login(requestLoginDto);
        if(responseLoginDto.getAccessToken() != null && responseLoginDto.getRefreshToken() != null){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(JwtFilter.ACCESS_TOKEN, HEADER + responseLoginDto.getAccessToken());
            httpHeaders.add(JwtFilter.REFRESH_TOKEN, HEADER + responseLoginDto.getRefreshToken());

            return new ResponseEntity<>(new MsgDto(true, "로그인 성공", memberService.loginInfo(requestLoginDto)), httpHeaders, HttpStatus.OK);
        }
        return ResponseEntity.ok(new MsgDto(false, "로그인 실패", null));
    }

    @PostMapping("/logout")
    public ResponseEntity<MsgDto> logout(@RequestHeader(value = "X-AUTH-TOKEN") String refreshToken) {
        RequestLogoutDto requestLogoutDto = RequestLogoutDto.builder()
                .refreshToken(refreshToken.replace(HEADER, ""))
                .build();
        try {
            authService.logout(requestLogoutDto);
            return ResponseEntity.ok(new MsgDto(true, "로그아웃 성공", ResponseLogoutDto.builder().isLogout(true)));
        }catch (RuntimeException e) {
            return ResponseEntity.ok(new MsgDto(false, "로그아웃 실패", ResponseLogoutDto.builder().isLogout(false)));
        }
    }

//    @PostMapping(value = "/reissue")
//    public ResponseEntity<MsgDto> reissue(@RequestHeader(value = "X-AUTH-TOKEN") String refreshToken) {
//        RequestReissueDto requestReissueDto = RequestReissueDto.builder()
//                .refreshToken(refreshToken.replace(HEADER, ""))
//                .build();
//        try {
//            ResponseReissueDto responseReissueDto = authService.reissue(requestReissueDto);
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.add(JwtFilter.ACCESS_TOKEN, HEADER + responseReissueDto.getAccessToken());
//            httpHeaders.add(JwtFilter.REFRESH_TOKEN, HEADER + responseReissueDto.getRefreshToken());
//            return new ResponseEntity<>(new MsgDto(true, "토큰 재발급 성공", null), httpHeaders, HttpStatus.OK);
//        }catch (RuntimeException e) {
//            return ResponseEntity.ok(new MsgDto(false, "토큰 재발급 실패", null));
//        }
//    }
}
