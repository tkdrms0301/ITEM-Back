package kit.item.dto.entity.repairShop;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class EnableTimesDto {
    List<ReservationEnableTimeDto> reservationTimes;
}
