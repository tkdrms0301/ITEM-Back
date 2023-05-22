package kit.item.dto.request.device;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateDeviceDto {
    private Long deviceId;
    private Long categoryId;
    private Long brandId;
    private Long productId;
    private String directlyRegisterProductName;
}
