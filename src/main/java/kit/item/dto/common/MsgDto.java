package kit.item.dto.common;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class MsgDto {
    private boolean isSuccess;
    private String msg;
    private Object data;

    public MsgDto(boolean isSuccess, String msg) {
        this.isSuccess = isSuccess;
        this.msg = msg;
        this.data = null;
    }
}
