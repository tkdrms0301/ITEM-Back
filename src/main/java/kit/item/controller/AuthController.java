package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.request.auth.*;
import kit.item.dto.response.auth.ResponseLoginDto;
import kit.item.dto.response.auth.ResponseLogoutDto;
import kit.item.exception.DuplicateMemberException;
import kit.item.service.auth.AuthService;
import kit.item.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static kit.item.util.prefix.ConstPrefix.ACCESS_TOKEN;

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
            httpHeaders.add(ACCESS_TOKEN, HEADER + responseLoginDto.getAccessToken());
            return new ResponseEntity<>(new MsgDto(true, "로그인 성공", memberService.getLoginInfo(requestLoginDto)), httpHeaders, HttpStatus.OK);
        }
        return ResponseEntity.ok(new MsgDto(false, "로그인 실패", null));
    }

    @PostMapping("/email-check")
    public ResponseEntity<MsgDto> emailCheck(@RequestBody RequestEmailCheckDto requestEmailCheckDto) {
        boolean isExistEmail = memberService.emailCheck(requestEmailCheckDto.getEmail());
        if (!isExistEmail) {
            return ResponseEntity.ok(new MsgDto(true, "사용 가능한 이메일입니다", null));
        }
        return ResponseEntity.ok(new MsgDto(false, "중복된 이메일입니다", null));
    }

    @PostMapping("/nickname-check")
    public ResponseEntity<MsgDto> nicknameCheck(@RequestBody RequestNicknameCheckDto requestNicknameCheckDto) {
        boolean isExistNickname = memberService.nicknameCheck(requestNicknameCheckDto.getNickname());
        if (!isExistNickname) {
            return ResponseEntity.ok(new MsgDto(true, "사용 가능한 닉네임입니다", null));
        }
        return ResponseEntity.ok(new MsgDto(false, "중복된 닉네임입니다", null));
    }

    @PostMapping("/company-number-check")
    public ResponseEntity<MsgDto> companyNumberCheck(@RequestBody RequestCompanyNumberCheckDto requestCompanyNumberCheckDto) {
        boolean isExistCompanyNumber = memberService.companyNumberCheck(requestCompanyNumberCheckDto.getCompanyNumber());
        if (!isExistCompanyNumber) {
            return ResponseEntity.ok(new MsgDto(true, "사용 가능한 사업자 번호입니다", null));
        }
        return ResponseEntity.ok(new MsgDto(false, "중복된 사업자 번호입니다", null));
    }
}
