package kit.item.dto.entity.member;

import kit.item.enums.RoleType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SellerInfoDto {
    private String companyName;
    private String companyNumber;
    private String companyPhoneNumber;
    private String description;
    private String companyAddress;
}
