package kit.item.dto.entity.device;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyDeviceTypeDto {
    private String summary;
    private List<DeviceDto> detail;
}
