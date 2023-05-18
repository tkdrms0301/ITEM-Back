package kit.item.dto.request.point;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RequestCreatePointHistoryDto {

    private String serviceName;
    private String serviceType;
    private Long point;
    private LocalDateTime date;
}
