package kit.item.dto.entity.data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PosAndNegWithProductNameDto {
    private Long id;
    private Long positive;
    private Long negative;
    private String productName;
}
