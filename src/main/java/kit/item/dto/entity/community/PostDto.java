package kit.item.dto.entity.community;

import kit.item.domain.post.Comment;
import kit.item.domain.post.Post;
import kit.item.enums.RoleType;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime date;
    private Long report;
    private Long memberId;
    private String memberName;
    private String thumbnail;
    private int commentCount;

    public static PostDto fromPost(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .date(post.getDate())
                .report(post.getReport())
                .memberId(post.getMember().getId())
                .memberName(post.getMember().getNickname())
                .thumbnail(
                        post.getPostImages().size() > 0 ?
                                post.getPostImages().get(0).getUrl() : null
                )
                .commentCount(
                        post.getComments().stream()
                                .mapToInt(comment -> comment.getChildrenComment().size() + 1)
                                .sum()
                )
                .build();
    }
}
