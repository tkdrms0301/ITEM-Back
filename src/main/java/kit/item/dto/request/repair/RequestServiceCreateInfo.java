package kit.item.dto.request.repair;

import kit.item.enums.ServiceType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestServiceCreateInfo {
    private ServiceType serviceType;
    private String serviceName;
    private String description;
}
