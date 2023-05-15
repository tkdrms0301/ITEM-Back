package kit.item.service.point;


import kit.item.domain.point.PointHistory;
import kit.item.dto.entity.point.PointHistoryDto;
import kit.item.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointRepository;
    public Object getPointHistory(Long memberId) {
        log.info("PointService.getPointHistory");
        List<PointHistoryDto> pointHistoryDtos = pointRepository.findPointHistoryByMemberId(memberId);

        return pointHistoryDtos;
    }

    public Object getPointHistoryByPeriod(Long memberId, LocalDateTime startDate, LocalDateTime endDate) {
        log.info("PointService.getPointHistory");
        List<PointHistoryDto> pointHistoryDtos = pointRepository.findPointHistoryByMemberIdAndDateRange(memberId, startDate, endDate);
        return pointHistoryDtos;
    }

    public boolean getPointHistoryDelete(Long historyId) {
        log.info("PointService.getPointHistoryDelete");
        Optional<PointHistory> pointHistoryDto = pointRepository.findById(historyId);

        if(pointHistoryDto.isPresent()){
            pointRepository.deleteById(historyId);
            return true;
        }

        return false;
    }
}
