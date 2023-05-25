package kit.item.dto.entity.data;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DataResultDto {
    private String word;
    private List<RelatedWordDto> relatedWords;
    private PosAndNegDto posAndNegDto;
}
