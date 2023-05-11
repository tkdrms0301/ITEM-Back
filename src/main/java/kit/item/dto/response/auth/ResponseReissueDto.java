package kit.item.dto.response.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseReissueDto {
    private String accessToken;
    private String refreshToken;
}
