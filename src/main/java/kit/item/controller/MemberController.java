package kit.item.controller;

import kit.item.dto.common.MsgDto;
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

    @GetMapping("/member")
    public String member() {
        return "member";
    }

    @GetMapping("/seller")
    public String seller() {
        return "seller";
    }

    @GetMapping("/mechanic")
    public String mechanic() {
        return "mechanic";
    }
}
