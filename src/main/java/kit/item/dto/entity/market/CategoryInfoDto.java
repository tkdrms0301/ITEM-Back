package kit.item.dto.entity.market;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CategoryInfoDto {
    private Long id;
    private String title;
    private String image;
}
