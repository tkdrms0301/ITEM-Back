package kit.item.service.point;


import kit.item.domain.member.Member;
import kit.item.domain.point.PointHistory;
import kit.item.dto.entity.point.PointHistoryDto;
import kit.item.dto.request.point.RequestCreatePointHistoryDto;
import kit.item.dto.request.point.RequestGetIncomeHistoryDateAndServiceNameDto;
import kit.item.repository.point.PointRepository;
import kit.item.repository.member.MemberRepository;
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
    private final MemberRepository memberRepository;

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

    public boolean getPointHistoryDelete(Long historyId, Long memberId) {
        log.info("PointService.getPointHistoryDelete");
        boolean isExist = pointRepository.existsByMemberIdAndHistoryId(memberId, historyId);

        if(isExist){
            pointRepository.deleteById(historyId);
            return true;
        }

        return false;
    }

    public boolean createHistory(Long memberId, RequestCreatePointHistoryDto requestCreatePointHistoryDto){
        log.info("PointService.createHistory");

        Optional<Member> member = memberRepository.findById(memberId);

        if(member.isPresent()){
            PointHistory pointHistory = PointHistory.builder()
                    .serviceName(requestCreatePointHistoryDto.getServiceName())
                    .serviceType(requestCreatePointHistoryDto.getServiceType())
                    .point(requestCreatePointHistoryDto.getPoint())
                    .date(requestCreatePointHistoryDto.getDate())
                    .member(member.get())
                    .build();

            pointRepository.save(pointHistory);
            return true;

        }else

            return false;
    }

    public Object getIncomeHistory(Long memberId) {
        log.info("PointService.getIncomeHistory");
        List<PointHistoryDto> pointHistoryDtos = pointRepository.findIncomeHistoryByMemberId(memberId);
        return pointHistoryDtos;
    }

    public Object getIncomeHistoryDateAndServiceName(Long memberId, RequestGetIncomeHistoryDateAndServiceNameDto requestGetIncomeHistoryDateAndServiceTypeDto) {
        log.info("PointService.getIncomeHistoryDateAndServiceName");

        LocalDateTime startDate = requestGetIncomeHistoryDateAndServiceTypeDto.getStartDate().withHour(00).withMinute(00).withSecond(00);
        LocalDateTime endDate = requestGetIncomeHistoryDateAndServiceTypeDto.getEndDate().withHour(23).withMinute(59).withSecond(59);
        List<String> serviceNames = requestGetIncomeHistoryDateAndServiceTypeDto.getServiceName();


        List<PointHistoryDto> pointHistoryDtos = pointRepository.findIncomeHistoryByMemberIdAndServiceNamesAndDateRange(memberId, serviceNames, startDate, endDate);

        return pointHistoryDtos;
    }
}
