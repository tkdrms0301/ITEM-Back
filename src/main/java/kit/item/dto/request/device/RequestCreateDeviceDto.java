package kit.item.dto.request.device;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreateDeviceDto {
    private Long categoryId;
    private Long brandId;
    private Long productId;
    private String directlyRegisterProductName;
}
