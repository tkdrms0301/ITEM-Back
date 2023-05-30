package kit.item.dto.entity.data;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PosAndNegCsvDto {
    private Long id;
    private String word;
    private String productName;
    private Long positive;
    private Long negative;
}
