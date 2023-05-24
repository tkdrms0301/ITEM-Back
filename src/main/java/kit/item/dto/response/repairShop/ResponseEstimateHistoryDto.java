package kit.item.dto.response.repairShop;

import kit.item.dto.entity.repairShop.MyItDeviceDto;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponseEstimateHistoryDto {
    private Long id;
    private MyItDeviceDto itDevice;
    private String requestImg;
    private String description;
    private String comment;
    private String status;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer minTime;
    private Integer maxTime;
    private LocalDateTime date;
}
