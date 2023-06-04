package kit.item.dto.response.repairShop;

import kit.item.dto.entity.repairShop.RepairServiceDto;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponsePrivateRepairShopDto {
    private Long repairShopId;
    private String shopName;
    private String shopAddress;
    private String shopPhoneNumber;
    private String description;
    private List<RepairServiceDto> services;
    private String shopType;
    private Long rating;
}
