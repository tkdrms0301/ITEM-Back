package kit.item.dto.entity.repairShop;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RepairServiceReviewDto {
    private Long reviewId;
    private String content;
    private Long rating;
}
