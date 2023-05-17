package kit.item.dto.request.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCompanyNumberCheckDto {
    private String companyNumber;
}
