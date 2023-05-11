package kit.item.dto.response.member;

import kit.item.enums.RoleType;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponseLoginMemberDto {
    private Long memberId;
    private String name;
    private RoleType roleType;
}
