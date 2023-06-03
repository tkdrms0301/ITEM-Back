package kit.item.dto.request.repair;

import kit.item.enums.ReportType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RequestReviewReportDto {
    private String reason;
    private ReportType reportType;
    private Long reviewId;
}
