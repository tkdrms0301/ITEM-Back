package kit.item.dto.response.auth;

import kit.item.domain.member.Member;
import kit.item.enums.RoleType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSignupDto {
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String phoneNumber;
    private String address;
    private Long point;
    private RoleType roleType;

    public static ResponseSignupDto of(Member member) {
        return ResponseSignupDto.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .name(member.getName())
                .nickname(member.getNickname())
                .phoneNumber(member.getPhoneNumber())
                .address(member.getAddress())
                .point(member.getPoint())
                .roleType(member.getRoleType())
                .build();
    }
}
