package kit.item.dto.request.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestReissueDto {
    private String accessToken;
    private String refreshToken;
}
