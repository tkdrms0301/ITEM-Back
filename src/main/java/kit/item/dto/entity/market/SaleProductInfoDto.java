package kit.item.dto.entity.market;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SaleProductInfoDto {
    Long id;
    String name;
    String thumbnailUrl;
    Integer price;
    String deliveryCompany;
    Integer deliveryCost;
    String comment;
    List<String> imageUrls;
    Long rating;
    List<SaleProductReviewInfoDto> reviewList;
}
