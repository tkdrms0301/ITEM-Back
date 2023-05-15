package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.request.member.RequestGetMemberInfoDto;
import kit.item.dto.request.point.RequestGetPointHistoryDateDto;
import kit.item.dto.request.point.RequestGetPointHistoryDto;
import kit.item.service.point.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/point")
public class PointController {
    private final PointService pointService;

    @GetMapping("/history")
    public ResponseEntity<MsgDto> getPointHistory(RequestGetPointHistoryDto requestGetPointHistoryDto) {
        return new ResponseEntity<>(new MsgDto(true, "포인트 이용내역 조회", pointService.getPointHistory(requestGetPointHistoryDto.getId())), HttpStatus.OK);
    }

    @GetMapping("/history/date")
    public ResponseEntity<MsgDto> getPointHistory(RequestGetPointHistoryDateDto requestGetPointHistoryDateDto) {
        LocalDateTime startDate = LocalDateTime.parse(requestGetPointHistoryDateDto.getStartDate());
        LocalDateTime endDate = LocalDateTime.parse(requestGetPointHistoryDateDto.getEndDate())
                .withHour(23)
                .withMinute(59)
                .withSecond(59);

        return new ResponseEntity<>(new MsgDto(true, "기간별 포인트 이용내역 조회", pointService.getPointHistoryByPeriod(requestGetPointHistoryDateDto.getId(), startDate, endDate)), HttpStatus.OK);
    }

    @DeleteMapping("/history")
    public ResponseEntity<MsgDto> getPointHistoryDelete(RequestGetPointHistoryDto requestGetPointHistoryDto) {
        return new ResponseEntity<>(new MsgDto(true, "포인트 이용내역 삭제", pointService.getPointHistoryDelete(requestGetPointHistoryDto.getId())), HttpStatus.OK);
    }


}
