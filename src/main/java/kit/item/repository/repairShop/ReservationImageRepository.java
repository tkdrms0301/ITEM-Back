package kit.item.repository.repairShop;

import kit.item.domain.repair.Reservation;
import kit.item.domain.repair.ReservationImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationImageRepository extends JpaRepository<ReservationImage, Long> {
    void deleteByReservation(Reservation reservation);
}
