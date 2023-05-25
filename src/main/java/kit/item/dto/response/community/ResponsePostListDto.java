package kit.item.dto.response.community;

import kit.item.dto.entity.community.PostDataDto;
import kit.item.dto.entity.community.PostDto;
import kit.item.dto.entity.member.MechanicInfoDto;
import kit.item.dto.entity.member.MemberInfoDto;
import kit.item.dto.entity.member.SellerInfoDto;
import kit.item.enums.RoleType;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponsePostListDto {
    private List<PostDto> posts;
    private boolean hasMore;

    public static ResponsePostListDto to(PostDto postDto, boolean hasMore){
        return ResponsePostListDto.builder()
                .posts(List.of(postDto))
                .hasMore(hasMore)
                .build();
    }
}
