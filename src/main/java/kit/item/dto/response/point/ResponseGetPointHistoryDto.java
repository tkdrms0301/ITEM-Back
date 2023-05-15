package kit.item.dto.response.point;

import kit.item.dto.entity.point.PointHistoryDto;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class ResponseGetPointHistoryDto {
    private List<PointHistoryDto> pointHistoryDtos;

}
