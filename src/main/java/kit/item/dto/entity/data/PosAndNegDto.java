package kit.item.dto.entity.data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PosAndNegDto {
    private Long positive;
    private Long negative;
}
