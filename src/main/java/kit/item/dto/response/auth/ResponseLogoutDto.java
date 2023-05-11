package kit.item.dto.response.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLogoutDto {
    private boolean isLogout;
}
