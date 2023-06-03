package kit.item.repository.repairShop;

import kit.item.domain.member.RepairShop;
import kit.item.domain.repair.RepairService;
import kit.item.domain.repair.Reservation;
import kit.item.dto.response.repairShop.ResponseReservaionHistoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByIdAndRepairShopId(Long reservationId, Long repairShopId);

    Optional<Reservation> findById(Long reservationId);
    @Query("SELECT r FROM RESERVATION r JOIN r.member m JOIN r.repairServiceReservations rs JOIN rs.repairService rsr WHERE rsr.repairShop.id = :repairShopId AND r.state IN ('정비 완료', '예약 완료')")
    List<Reservation> findUnableReservationByRepairShopId(@Param("repairShopId") Long repairShopId);

    @Query("SELECT r FROM RESERVATION r WHERE r.member.id = :memberId")
    List<Reservation> findByMemberId(@Param("memberId") Long memberId);


    @Query("SELECT rs FROM RESERVATION r " +
            "JOIN r.repairServiceReservations rsr " +
            "JOIN rsr.repairService rsc " +
            "JOIN rsc.repairShop rs " +
            "WHERE r.id = :reservationId")
    Optional<RepairShop> findRepairShopByReservationId(@Param("reservationId") Long reservationId);

    @Query("SELECT rsr.repairService FROM REPAIR_SERVICE_RESERVATION rsr WHERE rsr.reservation.id = :reservationId")
    List<RepairService> findRepairServicesByReservationId(@Param("reservationId") Long reservationId);


    List<Reservation> findByRepairShopId(Long repairShopId);
}