package kit.item.dto.response.community;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import kit.item.domain.post.Post;
import kit.item.dto.entity.community.PostImageDto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePostDto {
    String title;
    String content;
    Long memberId;
    String memberName;
    LocalDateTime date;
    String productName;
    Long productId;
    List<PostImageDto> images;

    public static ResponsePostDto fromPost(Post post) {
        //product null check
        if (post.getProduct() == null) {
            return ResponsePostDto.builder()
                    .title(post.getTitle())
                    .content(post.getContent())
                    .memberId(post.getMember().getId())
                    .memberName(post.getMember().getName())
                    .date(post.getDate())
                    .images(
                            post.getPostImages().stream()
                                    .map(postImage ->
                                            PostImageDto.builder()
                                                    .id(postImage.getImageId())
                                                    .url(postImage.getUrl())
                                                    .build()
                                            )
                                    .toList()
                    )
                    .build();
        }
        return ResponsePostDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .memberId(post.getMember().getId())
                .memberName(post.getMember().getName())
                .date(post.getDate())
                .productName(post.getProduct().getName())
                .productId(post.getProduct().getId())
                .images(
                        post.getPostImages().stream()
                                .map(postImage ->
                                        PostImageDto.builder()
                                                .id(postImage.getImageId())
                                                .url(postImage.getUrl())
                                                .build()
                                )
                                .toList()
                )
                .build();
    }
}
