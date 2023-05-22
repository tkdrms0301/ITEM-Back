package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairServiceReservation;
import kit.item.domain.repair.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairServiceReservationRepository extends JpaRepository<RepairServiceReservation, Long> {
    void deleteByReservation(Reservation reservation);


}
