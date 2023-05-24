package kit.item.dto.request.community;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreatePostDto {
    private String title;
    private String content;
    private Long productId;
    private List<String> images;
}
