package kit.item.dto.request.point;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestGetPointHistoryDateDto {
    private String startDate;
    private String endDate;
}
