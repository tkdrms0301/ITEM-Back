package kit.item.dto.response.community;

import kit.item.dto.entity.community.PostDataDto;
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
public class ResponsePostDataListDto {
    private List<PostDataDto> posts;
    private boolean hasMore;

    public static ResponsePostDataListDto to(List<PostDataDto> postDataDtos, boolean hasMore){
        return ResponsePostDataListDto.builder()
                .posts(postDataDtos)
                .hasMore(hasMore)
                .build();
    }
}
