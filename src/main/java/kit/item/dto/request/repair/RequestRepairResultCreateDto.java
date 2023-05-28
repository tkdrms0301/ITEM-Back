package kit.item.dto.request.repair;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RequestRepairResultCreateDto {
    private Long reservationId;
    private String comment;
    private List<MultipartFile> beforeRepairResultImages;
    private List<MultipartFile> afterRepairResultImages;
}
