package kit.item.dto.response.repairShop;

import kit.item.dto.entity.repairShop.MyItDeviceDto;
import kit.item.dto.entity.repairShop.ReservationServiceDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ResponseReservationInitDto {
    List<MyItDeviceDto> myItems;
    List<ReservationServiceDto> services;
}
