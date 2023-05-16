package kit.item.dto.response.repairShop;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponsePublicRepairShopDto {
    private Long officeShopId;
    private String shopName;
    private String shopAddress;
    private String shopPhoneNumber;
    private String description;
}
