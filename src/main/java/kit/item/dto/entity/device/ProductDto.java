package kit.item.dto.entity.device;

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
    private boolean roleType;
    private String kindName;
}
