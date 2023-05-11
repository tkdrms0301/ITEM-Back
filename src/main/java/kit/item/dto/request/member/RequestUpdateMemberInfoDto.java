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
    private String phoneNumber;
    private String address;
}
