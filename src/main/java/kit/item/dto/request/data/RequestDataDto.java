package kit.item.dto.request.data;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDataDto {
    private List<String> words;
    private List<Long> products;
}
