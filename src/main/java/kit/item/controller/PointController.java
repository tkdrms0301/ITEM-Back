package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.request.point.RequestGetIncomeHistoryDateAndServiceNameDto;
import kit.item.dto.request.point.RequestGetPointHistoryDateDto;
import kit.item.dto.request.point.RequestGetPointHistoryDto;
import kit.item.service.point.PointService;
import kit.item.util.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/point")
public class PointController {
    private final PointService pointService;
    private final TokenProvider tokenProvider;

    @GetMapping("/history")
    public ResponseEntity<MsgDto> getPointHistory(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return new ResponseEntity<>(new MsgDto(true, "포인트 이용내역 조회", pointService.getPointHistory(memberId)), HttpStatus.OK);
    }

    @GetMapping("/history/date")
    public ResponseEntity<MsgDto> getPointHistory(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken, RequestGetPointHistoryDateDto requestGetPointHistoryDateDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        LocalDateTime startDate = LocalDateTime.parse(requestGetPointHistoryDateDto.getStartDate())
                .withHour(00)
                .withMinute(00)
                .withSecond(00);
        LocalDateTime endDate = LocalDateTime.parse(requestGetPointHistoryDateDto.getEndDate())
                .withHour(23)
                .withMinute(59)
                .withSecond(59);

        return new ResponseEntity<>(new MsgDto(true, "기간별 포인트 이용내역 조회", pointService.getPointHistoryByPeriod(memberId, startDate, endDate)), HttpStatus.OK);
    }

    @DeleteMapping("/history")
    public ResponseEntity<MsgDto> getPointHistoryDelete(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken, RequestGetPointHistoryDto requestGetPointHistoryDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return new ResponseEntity<>(new MsgDto(true, "포인트 이용내역 삭제", pointService.getPointHistoryDelete(requestGetPointHistoryDto.getId(), memberId)), HttpStatus.OK);
    }

    @GetMapping("/income-history")
    public ResponseEntity<MsgDto> getIncomeHistory(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return new ResponseEntity<>(new MsgDto(true, "서비스 수익 내역 조회", pointService.getIncomeHistory(memberId)), HttpStatus.OK);
    }

    @PostMapping("/income-history/dateAndServiceName")
    public ResponseEntity<MsgDto> getIncomeHistoryDateAndServiceName(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken, @RequestBody RequestGetIncomeHistoryDateAndServiceNameDto requestGetIncomeHistoryDateAndServiceTypeDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return new ResponseEntity<>(new MsgDto(true, "서비스 수익 내역 조회", pointService.getIncomeHistoryDateAndServiceName(memberId, requestGetIncomeHistoryDateAndServiceTypeDto)), HttpStatus.OK);
    }

}
