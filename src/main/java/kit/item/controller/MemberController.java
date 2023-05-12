package kit.item.controller;

import kit.item.domain.member.Member;
import kit.item.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/hello")
    public String test() {
        return "hello";
    }

    @GetMapping("/all-members")
    public List<Member> findAllMembers() {
        return memberService.findAllMember();
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
