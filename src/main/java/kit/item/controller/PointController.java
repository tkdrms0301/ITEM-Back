package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.request.member.RequestGetMemberInfoDto;
import kit.item.dto.request.point.RequestGetPointHistoryDto;
import kit.item.service.point.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/point")
public class PointController {
    private final PointService pointService;

    @GetMapping("/history")
    public ResponseEntity<MsgDto> getPointHistory(RequestGetPointHistoryDto requestGetPointHistoryDto) {
        return new ResponseEntity<>(new MsgDto(true, "포인트 이용내역 조회", pointService.getPointHistory(requestGetPointHistoryDto.getId())), HttpStatus.OK);
    }

}
