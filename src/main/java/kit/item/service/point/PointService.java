package kit.item.service.point;


import kit.item.dto.entity.point.PointHistoryDto;
import kit.item.dto.response.point.ResponseGetPointHistoryDto;
import kit.item.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
