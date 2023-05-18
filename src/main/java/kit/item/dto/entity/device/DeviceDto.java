package kit.item.dto.entity.device;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceDto {
    private Long id;
    private Long categoryId;
    private Long brandId;
    private Long productId;
    private Long memberId;
    private String categoryName;
    private String brandName;
    private String productName;
    private String directlyRegisterProductName;
    private boolean isComponent;
}
