package kit.item.dto.entity.device;

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
    private String categoryName;
    private String brandName;
    private String productName;
    private String directlyRegisterProductName;
    private String url;
    private List<DeviceDto> components;

public DeviceDto(Long id, Long categoryId, Long brandId, Long productId, String categoryName, String brandName, String productName, String directlyRegisterProductName, String url) {
        this.id = id;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.productId = productId;
        this.categoryName = categoryName;
        this.brandName = brandName;
        this.productName = productName;
        this.directlyRegisterProductName = directlyRegisterProductName;
        this.url = url;
    }
}
