package kit.item.dto.request.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestEmailCheckDto {
    private String email;
}
