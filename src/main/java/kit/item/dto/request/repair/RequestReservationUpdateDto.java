package kit.item.dto.request.repair;

import kit.item.dto.entity.repairShop.ReservationServiceDto;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RequestReservationUpdateDto {
    private Long id;
    private String productName;
    private String prodImg;
    private String comment;
    private List<ReservationServiceDto> services;
    private List<MultipartFile> rvRequestImgs;
    private LocalDate date;
    private String time;
    private Long repairShopId;
}
