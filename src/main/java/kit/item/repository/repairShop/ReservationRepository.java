package kit.item.repository.repairShop;

import kit.item.domain.repair.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
//    List<Reservation> findByRepairShopId(Long repairShopId);
    @Query("SELECT r FROM RESERVATION r JOIN r.member m JOIN r.repairServiceReservations rs JOIN rs.repairService rsr WHERE rsr.repairShop.id = :repairShopId AND r.state IN ('정비 완료', '예약 완료')")
    List<Reservation> findUnableReservationByRepairShopId(@Param("repairShopId") Long repairShopId);
}