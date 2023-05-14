package kit.item.dto.request.member;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateMemberInfoDto {
    private Long id;
    private String name;
    private String nickname;
    private String currentPassword;
    private String newPassword;
    private String validPassword;
    private String phoneNumber;
    private String address;
}
