package kit.item.service.member;

import kit.item.domain.member.Member;
import kit.item.domain.member.RepairShop;
import kit.item.domain.member.Seller;
import kit.item.dto.entity.member.MechanicInfoDto;
import kit.item.dto.entity.member.MemberInfoDto;
import kit.item.dto.entity.member.MemberLoginInfoDto;
import kit.item.dto.entity.member.SellerInfoDto;
import kit.item.dto.request.auth.RequestLoginDto;
import kit.item.dto.request.auth.RequestSignupDto;
import kit.item.dto.request.member.RequestUpdateMemberInfoDto;
import kit.item.dto.response.member.ResponseGetMemberInfoDto;
import kit.item.dto.response.member.ResponseUpdateMemberInfoDto;
import kit.item.enums.RoleType;
import kit.item.exception.DuplicateMemberException;
import kit.item.repository.MechanicRepository;
import kit.item.repository.MemberRepository;
import kit.item.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final SellerRepository sellerRepository;
    private final MechanicRepository mechanicRepository;
    private final PasswordEncoder passwordEncoder;

    // Member가 DB에 존재할 시 Member 객체 반환
    @Override
    public UserDetails loadUserByUsername(String eamil) throws UsernameNotFoundException {
        log.info("MemberService.loadUserByEmail");
        log.info("LOGIN");
        return memberRepository.findByEmail(eamil)
                .orElseThrow(() -> new UsernameNotFoundException(eamil + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    public void signup(RequestSignupDto requestSignupDto) {
        log.info("MemberService.signup");
        if(memberRepository.existsByEmail(requestSignupDto.getEmail())) {
            throw new DuplicateMemberException("이미 가입되어 있는 중복된 이메일입니다.");
        }
        if(memberRepository.existsByNickname(requestSignupDto.getNickname())) {
            throw new DuplicateMemberException("이미 가입되어 있는 중복된 닉네임입니다.");
        }

        if (requestSignupDto.getRoleType().equals(RoleType.MEMBER)) {
            Member member = requestSignupDto.toMember();
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            memberRepository.save(member);
        } else if (requestSignupDto.getRoleType().equals(RoleType.SELLER) && requestSignupDto.getSellerInfoDto() != null) {
            Seller seller = requestSignupDto.toSeller();
            seller.setPassword(passwordEncoder.encode(seller.getPassword()));
            sellerRepository.save(seller);
        } else if (requestSignupDto.getRoleType().equals(RoleType.MECHANIC) && requestSignupDto.getMechanicInfoDto() != null) {
            RepairShop repairShop = requestSignupDto.toMechanic();
            repairShop.setPassword(passwordEncoder.encode(repairShop.getPassword()));
            mechanicRepository.save(repairShop);
        }
    }

    public boolean emailCheck(String email) {
        log.info("MemberService.emailCheck");
        return memberRepository.existsByEmail(email);
    }

    public boolean nicknameCheck(String nickname) {
        log.info("MemberService.emailCheck");
        return memberRepository.existsByNickname(nickname);
    }

    public MemberLoginInfoDto getLoginInfo(RequestLoginDto requestLoginDto) {
        log.info("MemberService.getLoginInfo");
        Optional<MemberLoginInfoDto> memberInfoDto = memberRepository.findMemberInfoByEmail(requestLoginDto.getEmail());
        if(memberInfoDto.isPresent()) {
            return MemberLoginInfoDto.builder()
                    .nickname(memberInfoDto.get().getNickname())
                    .roleType(memberInfoDto.get().getRoleType())
                    .build();
        }
        return new MemberLoginInfoDto();
    }

    public ResponseGetMemberInfoDto getMemberInfo(Long memberId) {
        log.info("MemberService.getMemberInfo");
        Optional<MemberInfoDto> memberDto = memberRepository.findMemberById(memberId);
        ResponseGetMemberInfoDto responseGetMemberInfoDto = null;
        if(memberDto.isPresent()) {
            responseGetMemberInfoDto = ResponseGetMemberInfoDto.to(memberDto.get());
            if (memberDto.get().getRoleType().equals(RoleType.MEMBER)) {
                return responseGetMemberInfoDto;
            }  else if (memberDto.get().getRoleType().equals(RoleType.SELLER)) {
                Optional<SellerInfoDto> sellerInfoDto = memberRepository.findSellerById(memberId);
                if (sellerInfoDto.isPresent()) {
                    responseGetMemberInfoDto.setSellerInfoDto(sellerInfoDto.get());
                }
                return responseGetMemberInfoDto;
            } else if (memberDto.get().getRoleType().equals(RoleType.MECHANIC)) {
                Optional<MechanicInfoDto> mechanicInfoDto = memberRepository.findMechanicById(memberId);
                if (mechanicInfoDto.isPresent()) {
                    responseGetMemberInfoDto.setMechanicInfoDto(mechanicInfoDto.get());
                }
                return responseGetMemberInfoDto;
            }
        }
        return new ResponseGetMemberInfoDto();
    }

    public ResponseUpdateMemberInfoDto updateMemberInfo(RequestUpdateMemberInfoDto requestUpdateMemberInfoDto, Long memberId) {
        log.info("MemberService.updateMemberInfo");
        Optional<Member> member = memberRepository.findById(memberId);
        if (!requestUpdateMemberInfoDto.getNewPassword().equals(requestUpdateMemberInfoDto.getValidPassword())) {
            ResponseUpdateMemberInfoDto.builder()
                    .isSuccess(false)
                    .msg("동일하지 않은 변경할 비밀번호 입력")
                    .build();
        }
        if (member.isEmpty()) {
            return ResponseUpdateMemberInfoDto.builder()
                    .msg("존재하지 않는 id")
                    .isSuccess(false)
                    .build();
        }
        if (passwordEncoder.matches(requestUpdateMemberInfoDto.getNewPassword(), member.get().getPassword())) {
            return ResponseUpdateMemberInfoDto.builder()
                    .msg("현재 비밀번호와 동일한 비밀번호 입력")
                    .isSuccess(false)
                    .build();
        }
        if (member.get().getRoleType().equals(RoleType.MEMBER)){
            memberRepository.updateMemberById(
                    requestUpdateMemberInfoDto.getAddress(),
                    requestUpdateMemberInfoDto.getNickname(),
                    passwordEncoder.encode(requestUpdateMemberInfoDto.getNewPassword()),
                    requestUpdateMemberInfoDto.getName(),
                    requestUpdateMemberInfoDto.getPhoneNumber(),
                    memberId
            );
        }else if (member.get().getRoleType().equals(RoleType.SELLER)) {
            sellerRepository.updateMechanicById(
                    requestUpdateMemberInfoDto.getAddress(),
                    requestUpdateMemberInfoDto.getNickname(),
                    passwordEncoder.encode(requestUpdateMemberInfoDto.getNewPassword()),
                    requestUpdateMemberInfoDto.getName(),
                    requestUpdateMemberInfoDto.getPhoneNumber(),
                    requestUpdateMemberInfoDto.getSellerInfoDto().getCompanyAddress(),
                    requestUpdateMemberInfoDto.getSellerInfoDto().getCompanyPhoneNumber(),
                    requestUpdateMemberInfoDto.getSellerInfoDto().getCompanyName(),
                    requestUpdateMemberInfoDto.getSellerInfoDto().getCompanyNumber(),
                    requestUpdateMemberInfoDto.getSellerInfoDto().getDescription(),
                    memberId
            );
        }else if (member.get().getRoleType().equals(RoleType.MECHANIC)) {
            mechanicRepository.updateMechanicById(
                    requestUpdateMemberInfoDto.getAddress(),
                    requestUpdateMemberInfoDto.getNickname(),
                    passwordEncoder.encode(requestUpdateMemberInfoDto.getNewPassword()),
                    requestUpdateMemberInfoDto.getName(),
                    requestUpdateMemberInfoDto.getPhoneNumber(),
                    requestUpdateMemberInfoDto.getMechanicInfoDto().getShopName(),
                    requestUpdateMemberInfoDto.getMechanicInfoDto().getShopPhoneNumber(),
                    requestUpdateMemberInfoDto.getMechanicInfoDto().getDescription(),
                    memberId
            );
        }
        return ResponseUpdateMemberInfoDto.builder()
                .msg("회원 정보 수정 완료")
                .isSuccess(true)
                .build();

    }
}
