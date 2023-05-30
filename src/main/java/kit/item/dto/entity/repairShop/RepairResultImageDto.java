package kit.item.dto.entity.repairShop;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RepairResultImageDto {
    private String url;
    private boolean isBefore;
}
