package kit.item.service.member;

import kit.item.domain.member.Member;
import kit.item.domain.member.RepairShop;
import kit.item.domain.member.Seller;
import kit.item.domain.point.PointHistory;
import kit.item.domain.point.Subscription;
import kit.item.dto.entity.member.MechanicInfoDto;
import kit.item.dto.entity.member.MemberInfoDto;
import kit.item.dto.entity.member.MemberLoginInfoDto;
import kit.item.dto.entity.member.SellerInfoDto;
import kit.item.dto.request.auth.RequestLoginDto;
import kit.item.dto.request.auth.RequestSignupDto;
import kit.item.dto.request.member.RequestUpdateMemberInfoDto;
import kit.item.dto.response.member.ResponseGetMemberInfoDto;
import kit.item.dto.response.member.ResponseSubscribeDto;
import kit.item.dto.response.member.ResponseUpdateMemberInfoDto;
import kit.item.enums.RoleType;
import kit.item.exception.DuplicateMemberException;
import kit.item.repository.point.PointRepository;
import kit.item.repository.member.MechanicRepository;
import kit.item.repository.member.MemberRepository;
import kit.item.repository.member.SellerRepository;
import kit.item.repository.point.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static kit.item.util.prefix.ConstData.*;
import static kit.item.util.prefix.ConstString.*;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final SellerRepository sellerRepository;
    private final MechanicRepository mechanicRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final PasswordEncoder passwordEncoder;
    private final PointRepository pointRepository;

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
        Subscription subscription = new Subscription(LocalDateTime.now().plusDays(SIGN_UP_SUBSCRIPTION_DURATION));
        if (requestSignupDto.getRoleType().equals(RoleType.MEMBER)) {
            Member member = requestSignupDto.toMember();
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            memberRepository.save(member);
            subscription.setMember(member);
            subscriptionRepository.save(subscription);
            pointRepository.save(PointHistory.builder()
                    .serviceName(SN_SIGN_UP_SUBSCRIPTION)
                    .serviceType(ST_SUBSCRIPTION_PURCHASE)
                    .point(0L)
                    .member(member)
                    .date(LocalDateTime.now())
                    .build());
        } else if (requestSignupDto.getRoleType().equals(RoleType.SELLER) && requestSignupDto.getSellerInfoDto() != null) {
            Seller seller = requestSignupDto.toSeller();
            seller.setPassword(passwordEncoder.encode(seller.getPassword()));
            sellerRepository.save(seller);
            subscription.setMember(seller);
            subscriptionRepository.save(subscription);
            pointRepository.save(PointHistory.builder()
                    .serviceName(SN_SIGN_UP_SUBSCRIPTION)
                    .serviceType(ST_SUBSCRIPTION_PURCHASE)
                    .point(0L)
                    .member(seller)
                    .date(LocalDateTime.now())
                    .build());
        } else if (requestSignupDto.getRoleType().equals(RoleType.MECHANIC) && requestSignupDto.getMechanicInfoDto() != null) {
            RepairShop repairShop = requestSignupDto.toMechanic();
            repairShop.setPassword(passwordEncoder.encode(repairShop.getPassword()));
            mechanicRepository.save(repairShop);
            subscription.setMember(repairShop);
            subscriptionRepository.save(subscription);
            pointRepository.save(PointHistory.builder()
                    .serviceName(SN_SIGN_UP_SUBSCRIPTION)
                    .serviceType(ST_SUBSCRIPTION_PURCHASE)
                    .point(0L)
                    .member(repairShop)
                    .date(LocalDateTime.now())
                    .build());
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

    public boolean companyNumberCheck(String companyNumber) {
        log.info("MemberService.companyNumberCheck");
        return sellerRepository.existsByCompanyNumber(companyNumber);
    }

    public boolean passwordCheck(Long memberId, String password) {
        log.info("MemberService.passwordCheck");
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isPresent()) {
            return passwordEncoder.matches(password, member.get().getPassword());
        }
        return false;
    }

    public boolean emailCheckUpdate(String email, Long memberId) {
        log.info("MemberService.emailCheck");
        return memberRepository.existsByEmailAndIdNot(email, memberId);
    }

    public boolean nicknameCheckUpdate(String nickname, Long memberId) {
        log.info("MemberService.emailCheck");
        return memberRepository.existsByNicknameAndIdNot(nickname, memberId);
    }

    public boolean companyNumberCheckUpdate(String companyNumber, Long memberId) {
        log.info("MemberService.companyNumberCheck");
        return sellerRepository.existsByCompanyNumberAndIdNot(companyNumber, memberId);
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
                    requestUpdateMemberInfoDto.getPhoneNumber(),
                    requestUpdateMemberInfoDto.getAccount(),
                    memberId
            );
        }else if (member.get().getRoleType().equals(RoleType.SELLER)) {
            sellerRepository.updateMechanicById(
                    requestUpdateMemberInfoDto.getAddress(),
                    requestUpdateMemberInfoDto.getNickname(),
                    passwordEncoder.encode(requestUpdateMemberInfoDto.getNewPassword()),
                    requestUpdateMemberInfoDto.getPhoneNumber(),
                    requestUpdateMemberInfoDto.getAccount(),
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
                    requestUpdateMemberInfoDto.getPhoneNumber(),
                    requestUpdateMemberInfoDto.getAccount(),
                    requestUpdateMemberInfoDto.getMechanicInfoDto().getShopName(),
                    requestUpdateMemberInfoDto.getMechanicInfoDto().getShopPhoneNumber(),
                    requestUpdateMemberInfoDto.getMechanicInfoDto().getDescription(),
                    requestUpdateMemberInfoDto.getMechanicInfoDto().getRepairServiceType(),
                    memberId
            );
        }
        return ResponseUpdateMemberInfoDto.builder()
                .msg("회원 정보 수정 완료")
                .isSuccess(true)
                .build();
    }

    public boolean subscribe(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
            if (member.get().checkPoint(SUBSCRIPTION_PRICE)) {
                Subscription subscription = null;
                if (subscriptionRepository.existsByMemberId(memberId)) {
                    subscription = subscriptionRepository.findByMemberId(memberId);
                    if (subscription.getEndDate().isBefore(LocalDateTime.now())) {
                        subscription.setEndDate(LocalDateTime.now().plusDays(PURCHASE_SUBSCRIPTION_DURATION));
                    }
                    subscription.setEndDate(subscription.getEndDate().plusDays(PURCHASE_SUBSCRIPTION_DURATION));
                } else {
                    subscription = new Subscription(LocalDateTime.now().plusDays(PURCHASE_SUBSCRIPTION_DURATION));
                    subscription.setMember(member.get());
                }
                member.get().usePoint(SUBSCRIPTION_PRICE);
                memberRepository.save(member.get());
                subscriptionRepository.save(subscription);
                pointRepository.save(PointHistory.builder()
                        .serviceName(SN_BASIC_SUBSCRIPTION)
                        .serviceType(ST_SUBSCRIPTION_PURCHASE)
                        .point(-SUBSCRIPTION_PRICE)
                        .member(member.get())
                        .date(LocalDateTime.now())
                        .build());
                return true;
            }
        }
        return false;
    }
}
