package kit.item.dto.response.repairShop;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponseReservationInfoDto {
    private String productName;
    private String productImageUrl;
    private String comment;
    private LocalDateTime applicationDate;
    private LocalDateTime reservationDate;
    private List<String> reservationImages;
}
