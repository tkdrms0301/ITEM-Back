package kit.item.dto.response.member;

import kit.item.dto.entity.member.MemberInfoDto;
import kit.item.enums.RoleType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponseGetMemberInfoDto {
    private Long id;
    private String email;
    private String name;
    private String nickname;
    private String phoneNumber;
    private String address;
    private Long point;
    private RoleType roleType;
    private boolean isSubscription;

    public static ResponseGetMemberInfoDto to(MemberInfoDto memberDto){

        LocalDateTime startDate = memberDto.getSubscriptionStartDate(); // 시작 시간 가져오기
        LocalDateTime currentDateTime = LocalDateTime.now(); // 현재 시간 가져오기
        LocalDateTime oneYearLater = startDate.plusYears(1); // 시작 시간으로부터 1년 후 계산

        boolean isOneYearPassed = oneYearLater.isAfter(currentDateTime); // 1년 후가 현재 시간보다 미래인지 확인

        return ResponseGetMemberInfoDto.builder()
                .id(memberDto.getId())
                .email(memberDto.getEmail())
                .name(memberDto.getName())
                .nickname(memberDto.getNickname())
                .phoneNumber(memberDto.getPhoneNumber())
                .address(memberDto.getAddress())
                .point(memberDto.getPoint())
                .roleType(memberDto.getRoleType())
                .isSubscription(isOneYearPassed)
                .build();
    }
}
