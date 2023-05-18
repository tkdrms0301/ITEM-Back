package kit.item.dto.entity.device;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CategoryDto {
    private Long categoryId;
    private String url;
    private String categoryName;
}
