package kit.item.dto.request.point;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RequestGetIncomeHistoryDateAndServiceNameDto {

    private List<String> serviceName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
