package kit.item.dto.request.auth;

import jakarta.persistence.Column;
import kit.item.domain.member.Member;
import kit.item.domain.member.RepairShop;
import kit.item.domain.member.Seller;
import kit.item.dto.entity.member.MechanicInfoDto;
import kit.item.dto.entity.member.SellerInfoDto;
import kit.item.enums.RoleType;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestSignupDto {
    private String email;
    private String password;
    private String validPassword;
    private String name;
    private String nickname;
    private String phoneNumber;
    private String address;
    private RoleType roleType;
    private String account;
    private SellerInfoDto sellerInfoDto;
    private MechanicInfoDto mechanicInfoDto;

    public Member toMember() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .nickname(nickname)
                .phoneNumber(phoneNumber)
                .address(address)
                .point(0L)
                .roleType(RoleType.MEMBER)
                .account(account)
                .build();
    }

    public Seller toSeller() {
        Seller seller = new Seller();
        seller.setEmail(email);
        seller.setPassword(password);
        seller.setName(name);
        seller.setNickname(nickname);
        seller.setPhoneNumber(phoneNumber);
        seller.setAddress(address);
        seller.setPoint(0L);
        seller.setRoleType(RoleType.SELLER);
        seller.setAccount(account);
        seller.setCompanyName(sellerInfoDto.getCompanyName());
        seller.setCompanyNumber(sellerInfoDto.getCompanyNumber());
        seller.setCompanyPhoneNumber(sellerInfoDto.getCompanyPhoneNumber());
        seller.setDescription(sellerInfoDto.getDescription());
        seller.setCompanyAddress(sellerInfoDto.getCompanyAddress());
        return seller;
    }

    public RepairShop toMechanic() {
        RepairShop repairShop = new RepairShop();
        repairShop.setEmail(email);
        repairShop.setPassword(password);
        repairShop.setName(name);
        repairShop.setNickname(nickname);
        repairShop.setPhoneNumber(phoneNumber);
        repairShop.setAddress(address);
        repairShop.setPoint(0L);
        repairShop.setRoleType(RoleType.MECHANIC);
        repairShop.setAccount(account);
        repairShop.setShopName(mechanicInfoDto.getShopName());
        repairShop.setShopAddress(mechanicInfoDto.getShopAddress());
        repairShop.setShopPhoneNumber(mechanicInfoDto.getShopPhoneNumber());
        repairShop.setDescription(mechanicInfoDto.getDescription());
        return repairShop;
    }
}
