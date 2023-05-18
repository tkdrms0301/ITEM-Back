package kit.item.dto.entity.device;

import kit.item.enums.ProductType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductDto {
    private Long productId;
    private String productName;
}
