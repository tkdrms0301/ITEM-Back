package kit.item.dto.request.device;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreatePartDto {
    private Long categoryId;
    private Long brandId;
    private Long productId;
    private String directlyRegisterProductName;
    private Long finishedDeviceId;
}
