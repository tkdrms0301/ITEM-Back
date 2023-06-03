package kit.item.dto.entity.community;

import kit.item.domain.post.Comment;
import kit.item.domain.post.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CommentDto {
    private Long id;
    private String content;
    private LocalDateTime date;
    private Long report;
    private Long memberId;
    private String memberName;
    private List<CommentDto> comments;

    public static CommentDto fromComment(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .date(comment.getDate())
                .report(comment.getReport())
                .memberId(comment.getMember().getId())
                .memberName(comment.getMember().getNickname())
                .comments(comment.getChildrenComment() == null ? null : comment.getChildrenComment().stream()
                        .map(CommentDto::fromComment)
                        .toList())
                .build();
    }
}
