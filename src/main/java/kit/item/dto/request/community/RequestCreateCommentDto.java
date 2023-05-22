package kit.item.dto.request.community;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreateCommentDto {
    private String content;

    public static RequestCreateCommentDto fromRequestCreateCommentDTO(String content) {
        return RequestCreateCommentDto.builder()
                .content(content)
                .build();
    }
}
