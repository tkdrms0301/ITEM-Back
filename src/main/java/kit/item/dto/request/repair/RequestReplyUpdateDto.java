package kit.item.dto.request.repair;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RequestReplyUpdateDto {
    private String content;
    private Long reviewId;
}
