package kit.item.domain.repair;

import jakarta.persistence.*;
import kit.item.domain.it.Product;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity(name = "REPAIR_SERVICE_RESERVATION")
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
public class RepairServiceReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_service_reservation_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repair_service_id")
    @ToString.Exclude
    private RepairService repairService;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    @ToString.Exclude
    private Reservation reservation;

    public void setRepairService(RepairService repairService) {
        this.repairService = repairService;
    }
}
