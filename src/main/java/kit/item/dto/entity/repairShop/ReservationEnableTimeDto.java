package kit.item.dto.entity.repairShop;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ReservationEnableTimeDto {
    String time;
    boolean isEnable;
}
