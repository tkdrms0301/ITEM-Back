package kit.item.dto.entity.member;

import kit.item.enums.RepairServiceType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MechanicInfoDto {
    private String description;
    private String shopName;
    private String shopPhoneNumber;
    private String shopAddress;
    private RepairServiceType repairServiceType;
}
