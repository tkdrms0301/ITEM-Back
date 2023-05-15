package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.request.member.RequestGetMemberInfoDto;
import kit.item.dto.request.member.RequestUpdateMemberInfoDto;
import kit.item.dto.response.member.ResponseGetMemberInfoDto;
import kit.item.dto.response.member.ResponseUpdateMemberInfoDto;
import kit.item.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/info")
    public ResponseEntity<MsgDto> getMemberInfo(RequestGetMemberInfoDto requestMemberDto) {
        return new ResponseEntity<>(new MsgDto(true, "회원 조회", memberService.getMemberInfo(requestMemberDto.getId())), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<MsgDto> updateMemberInfo(@RequestBody RequestUpdateMemberInfoDto requestUpdateMemberInfoDto) {
        ResponseUpdateMemberInfoDto responseUpdateMemberInfoDto = memberService.updateMemberInfo(requestUpdateMemberInfoDto);
        if(responseUpdateMemberInfoDto.isSuccess())
            return new ResponseEntity<>(new MsgDto(true, "회원 정보 수정 성공", responseUpdateMemberInfoDto), HttpStatus.OK);
        return new ResponseEntity<>(new MsgDto(false, "회원 정보 수정 실패", responseUpdateMemberInfoDto), HttpStatus.OK);
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
