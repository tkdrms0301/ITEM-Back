package kit.item.dto.request.data_server;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RequestPostDto {
    String content;
    Long productId;
}
