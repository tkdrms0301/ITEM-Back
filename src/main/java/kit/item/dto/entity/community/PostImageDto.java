package kit.item.dto.entity.community;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PostImageDto {
    private Long id;
    private String url;
}
