package kit.item.dto.request.repair;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RequestEstimateResponseDto {
    Long estimateId;
    String comment;
    Integer minPrice;
    Integer maxPrice;
    Integer minTime;
    Integer maxTime;
}
