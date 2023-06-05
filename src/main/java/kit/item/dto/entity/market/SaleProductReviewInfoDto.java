package kit.item.dto.entity.market;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SaleProductReviewInfoDto {
    Long id;
    Long ownerId;
    String ownerName;
    LocalDateTime date;
    String comment;
    Long rating;
}
