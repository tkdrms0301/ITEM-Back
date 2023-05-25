package kit.item.dto.entity.data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DataDto {
    private String vocab;
    private Long count;
    private Long productId;
}
