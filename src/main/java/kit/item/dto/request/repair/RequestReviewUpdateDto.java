package kit.item.dto.request.repair;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RequestReviewUpdateDto {
    private String content;
    private Long rating;
    private Long repairShopId;
}
