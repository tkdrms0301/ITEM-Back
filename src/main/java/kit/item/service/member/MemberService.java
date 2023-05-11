package kit.item.service.member;

import kit.item.domain.member.Member;
import kit.item.dto.entity.member.MemberInfoDto;
import kit.item.dto.entity.member.MemberLoginInfoDto;
import kit.item.dto.request.auth.RequestLoginDto;
import kit.item.dto.request.auth.RequestSignupDto;
import kit.item.dto.request.member.RequestUpdateMemberInfoDto;
import kit.item.dto.response.auth.ResponseLoginDto;
import kit.item.dto.response.auth.ResponseSignupDto;
import kit.item.dto.response.member.ResponseGetMemberInfoDto;
import kit.item.dto.response.member.ResponseUpdateMemberInfoDto;
import kit.item.exception.DuplicateMemberException;
import kit.item.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // Member가 DB에 존재할 시 Member 객체 반환
    @Override
    public UserDetails loadUserByUsername(String eamil) throws UsernameNotFoundException {
        log.info("MemberService.loadUserByEmail");
        log.info("LOGIN");
        return memberRepository.findByEmail(eamil)
                .orElseThrow(() -> new UsernameNotFoundException(eamil + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    public ResponseSignupDto signup(RequestSignupDto requestSignupDto) {
        log.info("MemberService.signup");
        if(memberRepository.existsByEmail(requestSignupDto.getEmail())) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        Member member = requestSignupDto.toMember(passwordEncoder);
        return ResponseSignupDto.of(memberRepository.save(member));
    }

    public MemberLoginInfoDto getLoginInfo(RequestLoginDto requestLoginDto) {
        log.info("MemberService.getLoginInfo");
        Optional<MemberLoginInfoDto> memberInfoDto = memberRepository.findMemberInfoByEmail(requestLoginDto.getEmail());
        if(memberInfoDto.isPresent()) {
            return MemberLoginInfoDto.builder()
                    .id(memberInfoDto.get().getId())
                    .nickname(memberInfoDto.get().getNickname())
                    .roleType(memberInfoDto.get().getRoleType())
                    .build();
        }
        return new MemberLoginInfoDto();
    }

    public ResponseGetMemberInfoDto getMemberInfo(Long memberId) {
        log.info("MemberService.getMemberInfo");
        Optional<MemberInfoDto> memberDto = memberRepository.findMemberById(memberId);
        if(memberDto.isPresent()) {
            return ResponseGetMemberInfoDto.to(memberDto.get());
        }
        return new ResponseGetMemberInfoDto();
    }

    public ResponseUpdateMemberInfoDto updateMemberInfo(RequestUpdateMemberInfoDto requestUpdateMemberInfoDto) {
        log.info("MemberService.updateMemberInfo");
        log.info(requestUpdateMemberInfoDto.getId().toString());
        Optional<Member> member = memberRepository.findById(requestUpdateMemberInfoDto.getId());
        if(member.isPresent()) {
            member.get().setAddress(requestUpdateMemberInfoDto.getAddress());
            member.get().setNickname(requestUpdateMemberInfoDto.getNickname());
            member.get().setName(requestUpdateMemberInfoDto.getName());
            member.get().setPhoneNumber(requestUpdateMemberInfoDto.getPhoneNumber());
            memberRepository.save(member.get());
            return ResponseUpdateMemberInfoDto.builder()
                    .isSuccess(true)
                    .build();
        }
        return ResponseUpdateMemberInfoDto.builder()
                .isSuccess(false)
                .build();
    }
}
