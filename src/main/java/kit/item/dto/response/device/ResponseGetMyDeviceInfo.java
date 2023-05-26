package kit.item.dto.response.device;

import kit.item.dto.entity.device.DeviceDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGetMyDeviceInfo {
    List<DeviceDto> computers;
    List<DeviceDto> notebooks;
    List<DeviceDto> smartPhones;
    List<DeviceDto> tablets;
}
