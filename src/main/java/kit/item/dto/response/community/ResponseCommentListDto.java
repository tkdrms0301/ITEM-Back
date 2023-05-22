package kit.item.dto.response.community;

import kit.item.dto.entity.community.CommentDto;
import kit.item.dto.entity.community.PostDto;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponseCommentListDto {
    private List<CommentDto> comments;
}
