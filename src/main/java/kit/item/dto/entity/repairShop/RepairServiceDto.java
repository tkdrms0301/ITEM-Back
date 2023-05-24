package kit.item.dto.entity.repairShop;

import kit.item.enums.ServiceType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RepairServiceDto {
    private Long serviceId;
    private String serviceName;
    private ServiceType serviceType;
    private String description;
}
