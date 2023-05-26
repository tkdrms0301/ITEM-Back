package kit.item.dto.response.member;

import kit.item.domain.member.RepairShop;
import kit.item.domain.member.Seller;
import kit.item.dto.entity.member.MechanicInfoDto;
import kit.item.dto.entity.member.MemberInfoDto;
import kit.item.dto.entity.member.SellerInfoDto;
import kit.item.enums.RoleType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponseGetMemberInfoDto {
    private Long id;
    private String email;
    private String name;
    private String nickname;
    private String phoneNumber;
    private String address;
    private String account;
    private Long point;
    private RoleType roleType;
    private LocalDate subscription;
    private SellerInfoDto sellerInfoDto;
    private MechanicInfoDto mechanicInfoDto;

    public static ResponseGetMemberInfoDto to(MemberInfoDto memberDto){
        return ResponseGetMemberInfoDto.builder()
                .id(memberDto.getId())
                .email(memberDto.getEmail())
                .name(memberDto.getName())
                .nickname(memberDto.getNickname())
                .phoneNumber(memberDto.getPhoneNumber())
                .address(memberDto.getAddress())
                .account(memberDto.getAccount())
                .point(memberDto.getPoint())
                .roleType(memberDto.getRoleType())
                .subscription(memberDto.getEndDate() != null ? memberDto.getEndDate().toLocalDate() : null)
                .build();
    }
}
