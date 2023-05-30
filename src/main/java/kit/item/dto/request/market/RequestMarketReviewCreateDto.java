package kit.item.dto.request.market;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RequestMarketReviewCreateDto {
    private String comment;
    private Long rating;
    private Long saleProductId;
}
