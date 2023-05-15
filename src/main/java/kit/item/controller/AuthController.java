package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.request.auth.*;
import kit.item.dto.response.auth.ResponseLoginDto;
import kit.item.dto.response.auth.ResponseLogoutDto;
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
        try{
            authService.signup(requestSignupDto);
        }catch (DuplicateMemberException e) {
            return ResponseEntity.ok(new MsgDto(false, "회원가입 실패", null));
        }
        return ResponseEntity.ok(new MsgDto(true, "회원가입 성공", null));
    }

    @PostMapping("/login")
    public ResponseEntity<MsgDto> login(@RequestBody RequestLoginDto requestLoginDto) {
        ResponseLoginDto responseLoginDto = authService.login(requestLoginDto);
        if(responseLoginDto.getAccessToken() != null){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(JwtFilter.ACCESS_TOKEN, HEADER + responseLoginDto.getAccessToken());
            return new ResponseEntity<>(new MsgDto(true, "로그인 성공", memberService.getLoginInfo(requestLoginDto)), httpHeaders, HttpStatus.OK);
        }
        return ResponseEntity.ok(new MsgDto(false, "로그인 실패", null));
    }

    @PostMapping("/logout")
    public ResponseEntity<MsgDto> logout(@RequestHeader(value = "X-AUTH-TOKEN") String refreshToken) {
        RequestLogoutDto requestLogoutDto = RequestLogoutDto.builder()
                .refreshToken(refreshToken.replace(HEADER, ""))
                .build();
        try {
            //authService.logout(requestLogoutDto);
            return ResponseEntity.ok(new MsgDto(true, "로그아웃 성공", ResponseLogoutDto.builder().isLogout(true)));
        }catch (RuntimeException e) {
            return ResponseEntity.ok(new MsgDto(false, "로그아웃 실패", ResponseLogoutDto.builder().isLogout(false)));
        }
    }

    @PostMapping("/email-check")
    public ResponseEntity<MsgDto> emailCheck(@RequestBody RequestEmailCheckDto requestEmailCheckDto) {
        boolean isExistEmail = memberService.emailCheck(requestEmailCheckDto.getEmail());
        if (!isExistEmail) {
            return ResponseEntity.ok(new MsgDto(isExistEmail, "이메일 사용 가능", null));
        }
        return ResponseEntity.ok(new MsgDto(isExistEmail, "중복된 이메일", null));
    }

    @PostMapping("/nickname-check")
    public ResponseEntity<MsgDto> nicknameCheck(@RequestBody RequestNicknameCheckDto requestNicknameCheckDto) {
        boolean isExistNickname = memberService.nicknameCheck(requestNicknameCheckDto.getNickname());
        if (!isExistNickname) {
            return ResponseEntity.ok(new MsgDto(isExistNickname, "닉네임 사용 가능", null));
        }
        return ResponseEntity.ok(new MsgDto(isExistNickname, "중복된 닉네임", null));
    }
}
