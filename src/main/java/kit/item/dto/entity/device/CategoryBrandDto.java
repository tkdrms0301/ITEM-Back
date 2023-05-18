package kit.item.dto.entity.device;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CategoryBrandDto {
    private Long categoryBrandId;
    private Long categoryId;
    private Long brandId;
}
