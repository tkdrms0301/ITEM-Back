package kit.item.dto.request.community;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreatePostDto {
    private String title;
    private String content;
    private Long memberId;

    public static RequestCreatePostDtoBuilder builder(String title, String content, Long memberId) {
        return new RequestCreatePostDtoBuilder().title(title).content(content).memberId(memberId);
    }
}
