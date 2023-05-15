package kit.item.dto.entity.point;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PointHistoryDto {
    private Long id;
    private LocalDateTime date;
    private long point;
    private String serviceName;
    private String serviceType;
}
