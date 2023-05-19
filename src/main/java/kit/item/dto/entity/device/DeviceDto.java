package kit.item.dto.entity.device;

import kit.item.enums.ProductType;
import lombok.*;

import java.util.List;

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
    private ProductType productType;
    private String imageUrl;
    private List<DeviceDto> components;

public DeviceDto(Long id, Long categoryId, Long brandId, Long productId, Long memberId, String categoryName, String brandName, String productName, String directlyRegisterProductName, ProductType productType, String imageUrl) {
        this.id = id;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.productId = productId;
        this.memberId = memberId;
        this.categoryName = categoryName;
        this.brandName = brandName;
        this.productName = productName;
        this.directlyRegisterProductName = directlyRegisterProductName;
        this.productType = productType;
        this.imageUrl = imageUrl;
    }
}
