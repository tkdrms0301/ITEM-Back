package kit.item.dto.entity.market;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class MarketReviewDto {
    private Long reviewId;
    private String reviewComment;
    private Long rating;
    private Long replyId;
    private String replyComment;
}
