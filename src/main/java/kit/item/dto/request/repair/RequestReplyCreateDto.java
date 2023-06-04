package kit.item.dto.request.repair;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RequestReplyCreateDto {
    private String content;
    private Long reviewId;
}
