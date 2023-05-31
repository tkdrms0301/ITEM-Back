package kit.item.dto.entity.community;

import kit.item.domain.member.Member;
import kit.item.domain.post.Comment;
import kit.item.domain.post.Post;
import kit.item.domain.post.PostImage;
import kit.item.enums.RoleType;
import kit.item.repository.community.PostRepository;
import kit.item.service.community.CommunityService;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
}
