package kit.item.dto.entity.device;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BrandDto {
    Long categoryBrandId;
    Long brandId;
    Long categoryId;
    String brandName;
}
