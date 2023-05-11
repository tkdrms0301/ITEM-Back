package kit.item.dto.request.auth;

import kit.item.domain.member.Member;
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
    private String name;
    private String nickname;
    private String phoneNumber;
    private String address;
    private Long point;
    private RoleType roleType;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .nickname(nickname)
                .phoneNumber(phoneNumber)
                .address(address)
                .point(point)
                .roleType(roleType)
                .build();
    }
}
