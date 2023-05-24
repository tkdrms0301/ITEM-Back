package kit.item.dto.entity.member;

import kit.item.enums.RoleType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MemberInfoDto {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String phoneNumber;
    private String address;
    private String account;
    private Long point;
    private RoleType roleType;
    private LocalDateTime endDate;
}
