package kit.item.service.member;

import kit.item.domain.mysql.member.Member;
import kit.item.dto.request.auth.RequestLoginDto;
import kit.item.dto.request.auth.RequestSignupDto;
import kit.item.dto.response.auth.ResponseLoginDto;
import kit.item.dto.response.auth.ResponseSignupDto;
import kit.item.dto.response.member.ResponseLoginMemberDto;
import kit.item.enums.RoleType;
import kit.item.exception.DuplicateMemberException;
import kit.item.repository.mysql.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // Member가 DB에 존재할 시 Member 객체 반환
    @Override
    public UserDetails loadUserByUsername(String eamil) throws UsernameNotFoundException {
        log.info("UserDetailsService.loadUserByEmail");
        log.info("LOGIN");
        return memberRepository.findByEmail(eamil)
                .orElseThrow(() -> new UsernameNotFoundException(eamil + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    public ResponseSignupDto signup(RequestSignupDto requestSignupDto) {
        if(memberRepository.existsByEmail(requestSignupDto.getEmail())) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        Member member = requestSignupDto.toMember(passwordEncoder);
        return ResponseSignupDto.of(memberRepository.save(member));
    }

    public ResponseLoginMemberDto loginInfo(RequestLoginDto requestLoginDto){
        Long memberId = 1L;
        String name = "홍길동";
        RoleType roleType = RoleType.MEMBER;

        return ResponseLoginMemberDto.builder()
                .memberId(memberId)
                .name(name)
                .roleType(roleType)
                .build();
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }
}
