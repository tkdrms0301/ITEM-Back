package kit.item.dto.request.community;

import kit.item.enums.ReportType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestReportDto {
    private String reason;
    private ReportType reportType;
}
