package kit.item.dto.response.repairShop;

import kit.item.dto.entity.repairShop.RepairServiceReplyDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ResponseRepairServiceReviewDto {
    private Long reviewId;
    private String content;
    private Long rating;
    private RepairServiceReplyDto repairServiceReplyDto;
}
