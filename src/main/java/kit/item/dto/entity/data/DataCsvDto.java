package kit.item.dto.entity.data;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DataCsvDto {
    private Long id;
    private String word;
    private String productName;
    private String vocab;
    private Long count;
}
