package kit.item.dto.entity.market;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ReportCountDto {
    Long id;
    Long count;

    public ReportCountDto(Long id, Long count) {
        this.id = id;
        this.count = count;
    }
}
