package kit.item.dto.entity.repairShop;

import kit.item.domain.repair.RepairServiceReview;
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
    private String reviewContent;
    private Long rating;
    private Long replyId;
    private String replyContent;
}
