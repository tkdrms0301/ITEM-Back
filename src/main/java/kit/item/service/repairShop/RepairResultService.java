package kit.item.service.repairShop;

import kit.item.domain.repair.Reservation;
import kit.item.domain.repair.ReservationImage;
import kit.item.dto.request.repair.RequestCreateRepairResult;
import kit.item.repository.repairShop.RepairResultReportRepository;
import kit.item.repository.repairShop.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RepairResultService {
    private final RepairResultReportRepository repairResultReportRepository;
    private final ReservationRepository reservationRepository;

    public void findReservationInfo(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            Reservation reservationInfo = reservation.get();
            List<ReservationImage> reservationImages = reservationInfo.getReservationImages();
        }
    }

    public void createRepairResult(RequestCreateRepairResult requestCreateRepairResult) {

    }


}
