package kit.item.dto.entity.community;

import kit.item.domain.post.Post;
import kit.item.enums.RoleType;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PostDataDto {
    private Long id;
    private String title;

    public PostDataDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
    public static PostDataDto fromPost(Post post) {
        return PostDataDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .build();
    }
}
