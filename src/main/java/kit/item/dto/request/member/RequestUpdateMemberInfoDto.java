package kit.item.dto.request.member;

import kit.item.dto.entity.member.MechanicInfoDto;
import kit.item.dto.entity.member.SellerInfoDto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateMemberInfoDto {
    private String name;
    private String nickname;
    private String currentPassword;
    private String newPassword;
    private String validPassword;
    private String phoneNumber;
    private String address;
    private String account;
    private SellerInfoDto sellerInfoDto;
    private MechanicInfoDto mechanicInfoDto;
}
