package kit.item.dto.common;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MsgDto {
    private boolean isSuccess;
    private String msg;
    private Object data;
}
