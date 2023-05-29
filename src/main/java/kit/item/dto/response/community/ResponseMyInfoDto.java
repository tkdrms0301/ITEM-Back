package kit.item.dto.response.community;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMyInfoDto {
    private String nickname;
    private Long postCount;
    private Long commentCount;
}
