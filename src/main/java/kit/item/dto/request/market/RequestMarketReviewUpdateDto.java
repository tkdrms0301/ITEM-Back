package kit.item.dto.request.market;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RequestMarketReviewUpdateDto {
    private String comment;
    private Long rating;
    private Long saleProductId;
}