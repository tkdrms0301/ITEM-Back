package kit.item.dto.request.repair;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RequestEstimateDto {
    Long productId;
    Long repairShopId;
    String comment;
    MultipartFile requestImg;
}
