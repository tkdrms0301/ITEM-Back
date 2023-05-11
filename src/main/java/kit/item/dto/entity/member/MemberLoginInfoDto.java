package kit.item.dto.entity.member;

import kit.item.enums.RoleType;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MemberLoginInfoDto {
    private Long id;
    private String nickname;
    private RoleType roleType;
}
