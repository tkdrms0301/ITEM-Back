package kit.item.dto.entity.data;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DataResultDto implements Comparable<DataResultDto> {
    private Long productId;
    private String word;
    private String productName;
    private List<RelatedWordDto> relatedWords;
    private PosAndNegDto posAndNegDto;

    @Override
    public int compareTo(@NotNull DataResultDto o) {
        return (int) (o.getProductId() - getProductId());
    }

    public boolean check(List<DataResultDto> dataResultDtoList) {
        for (DataResultDto dataResultDto : dataResultDtoList) {
            if (dataResultDto.getProductId().equals(productId)) {
                return true;
            }
        }
        return false;
    }
}
