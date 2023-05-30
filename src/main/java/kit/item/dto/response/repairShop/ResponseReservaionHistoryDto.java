package kit.item.dto.response.repairShop;

import kit.item.dto.entity.repairShop.ReservationServiceDto;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponseReservaionHistoryDto {
    private Long id;
    private Long repairShopId;
    private String shopName;
    private String productName;
    private String prodImg;
    private List<ReservationServiceDto> requestServices;
    private List<String> rvRequestImgs;
    private String requestComment;
    private LocalDate date;
    private String time;
    private String status;
    private List<ReservationServiceDto> services;
}
