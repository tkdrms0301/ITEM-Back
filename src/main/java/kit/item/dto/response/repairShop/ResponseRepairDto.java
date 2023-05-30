package kit.item.dto.response.repairShop;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ResponseRepairDto {
    private String comment;
    private LocalDateTime date;
    private List<String> beforeRepairResultImages;
    private List<String> afterRepairResultImages;
}
