package kit.item.dto.request.device;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDeletePartDto {
    private Long deviceId;
}