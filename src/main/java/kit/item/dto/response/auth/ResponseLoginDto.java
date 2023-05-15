package kit.item.dto.response.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLoginDto {
    private String accessToken;
}
