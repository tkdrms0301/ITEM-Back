package kit.item.service.repairShop;

import kit.item.domain.member.Member;
import kit.item.domain.repair.RepairServiceReservation;
import kit.item.domain.repair.Reservation;
import kit.item.dto.request.point.RequestCreatePointHistoryDto;
import kit.item.enums.PointUsageType;
import kit.item.enums.RoleType;
import kit.item.repository.it.ItDeviceRepository;
import kit.item.repository.member.MemberRepository;
import kit.item.repository.repairShop.*;
import kit.item.service.device.DeviceManagementService;
import kit.item.service.point.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class RepairShopUtilService {
    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;
    private final PointService pointService;

    public boolean returnPointByReservation(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {

            //포인트 획득, 포인트 히스토리
            AtomicLong totalPrice = new AtomicLong(0);
            Member consumer = reservation.get().getMember();
            List<RepairServiceReservation> repairServiceReservations = reservation.get().getRepairServiceReservations();


            StringBuilder serviceNames = new StringBuilder();
            AtomicInteger count = new AtomicInteger(0);

            repairServiceReservations.stream().forEach(repairServiceReservation -> {
                        totalPrice.addAndGet(repairServiceReservation.getRepairService().getPrice());
                        count.incrementAndGet();
                        if (count.get() < 2)
                            serviceNames.append(repairServiceReservation.getRepairService().getServiceName());
                    }
            );

            String finalServiceNames = serviceNames.toString();

            //소비자
            //포인트 획득
            consumer.setPoint(consumer.getPoint() + totalPrice.get());
            memberRepository.save(consumer);

            //포인트 히스토리
            RequestCreatePointHistoryDto consumerPointHistory = RequestCreatePointHistoryDto.builder()
                    .serviceName(finalServiceNames)
                    .serviceType(PointUsageType.RESERVATION_RETURN.getKrName())
                    .point(totalPrice.get())
                    .date(LocalDateTime.now()).build();
            pointService.createHistory(consumer.getId(), consumerPointHistory);


            Optional<Member> admin = memberRepository.findByRoleType(RoleType.ADMIN);

            //ADMIN
            //포인트 차감
            if(admin.isPresent()){
                admin.get().setPoint(admin.get().getPoint() - totalPrice.get());
                memberRepository.save(admin.get());

                //포인트 히스토리
                RequestCreatePointHistoryDto adminPointHistory = RequestCreatePointHistoryDto.builder()
                        .serviceName(finalServiceNames)
                        .serviceType(PointUsageType.RESERVATION_RETURN.getKrName())
                        .point(-totalPrice.get())
                        .date(LocalDateTime.now()).build();
                pointService.createHistory(admin.get().getId(), adminPointHistory);
            }

            return true;
        }
        return false;
    }
}
