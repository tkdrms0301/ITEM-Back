package kit.item.dto.response.data;

import kit.item.dto.entity.data.DataResultDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResposneDataDto {
    private List<DataResultDto> datas;
}
