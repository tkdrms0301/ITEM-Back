package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.request.auth.RequestCompanyNumberCheckDto;
import kit.item.dto.request.auth.RequestEmailCheckDto;
import kit.item.dto.request.auth.RequestNicknameCheckDto;
import kit.item.dto.request.auth.RequestPasswordCheckDto;
import kit.item.dto.request.member.RequestUpdateMemberInfoDto;
import kit.item.dto.response.member.ResponseUpdateMemberInfoDto;
import kit.item.service.member.MemberService;
import kit.item.util.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static kit.item.util.prefix.ConstPrefix.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;
    private final TokenProvider tokenProvider;

    @GetMapping("/info")
    public ResponseEntity<MsgDto> getMemberInfo(@RequestHeader(value = X_AUTH_TOKEN) String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return new ResponseEntity<>(new MsgDto(true, "회원 정보 조회 성공", memberService.getMemberInfo(memberId)), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<MsgDto> updateMemberInfo(
            @RequestHeader(value = X_AUTH_TOKEN) String accessToken,
            @RequestBody RequestUpdateMemberInfoDto requestUpdateMemberInfoDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        ResponseUpdateMemberInfoDto responseUpdateMemberInfoDto = memberService.updateMemberInfo(requestUpdateMemberInfoDto, memberId);
        return new ResponseEntity<>(new MsgDto(responseUpdateMemberInfoDto.isSuccess(), responseUpdateMemberInfoDto.getMsg(), null), HttpStatus.OK);
    }

    @PostMapping("/password-check")
    public ResponseEntity<MsgDto> passwordCheck(
            @RequestHeader(value = X_AUTH_TOKEN) String accessToken,
            @RequestBody RequestPasswordCheckDto requestPasswordCheck) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if(memberService.passwordCheck(memberId, requestPasswordCheck.getPassword())) {
            return new ResponseEntity<>(new MsgDto(true, "비밀번호 확인", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "동일한 비밀번호 입력", null), HttpStatus.OK);
    }

    @PostMapping("/subscribe")
    public ResponseEntity<MsgDto> subscribe(@RequestHeader(value = X_AUTH_TOKEN) String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if (memberService.subscribe(memberId)) {
            return new ResponseEntity<>(new MsgDto(true, "구독 성공", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "구독 실패", null), HttpStatus.OK);
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

    @PostMapping("/email-check-update")
    public ResponseEntity<MsgDto> emailCheckUpdate(@RequestHeader(value = X_AUTH_TOKEN) String accessToken,
                                                   @RequestBody RequestEmailCheckDto requestEmailCheckDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        boolean isExistEmail = memberService.emailCheckUpdate(requestEmailCheckDto.getEmail(), memberId);
        if (!isExistEmail) {
            return ResponseEntity.ok(new MsgDto(true, "사용 가능한 이메일입니다", null));
        }
        return ResponseEntity.ok(new MsgDto(false, "중복된 이메일입니다", null));
    }

    @PostMapping("/nickname-check-update")
    public ResponseEntity<MsgDto> nicknameCheckUpdate(@RequestHeader(value = X_AUTH_TOKEN) String accessToken,
                                                      @RequestBody RequestNicknameCheckDto requestNicknameCheckDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        boolean isExistNickname = memberService.nicknameCheckUpdate(requestNicknameCheckDto.getNickname(), memberId);
        if (!isExistNickname) {
            return ResponseEntity.ok(new MsgDto(true, "사용 가능한 닉네임입니다", null));
        }
        return ResponseEntity.ok(new MsgDto(false, "중복된 닉네임입니다", null));
    }

    @PostMapping("/company-number-check-update")
    public ResponseEntity<MsgDto> companyNumberCheckUpdate(@RequestHeader(value = X_AUTH_TOKEN) String accessToken,
                                                           @RequestBody RequestCompanyNumberCheckDto requestCompanyNumberCheckDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        boolean isExistCompanyNumber = memberService.companyNumberCheckUpdate(requestCompanyNumberCheckDto.getCompanyNumber(), memberId);
        if (!isExistCompanyNumber) {
            return ResponseEntity.ok(new MsgDto(true, "사용 가능한 사업자 번호입니다", null));
        }
        return ResponseEntity.ok(new MsgDto(false, "중복된 사업자 번호입니다", null));
    }
}
