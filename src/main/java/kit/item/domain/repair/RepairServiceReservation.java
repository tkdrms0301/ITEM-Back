package kit.item.domain.repair;

import jakarta.persistence.*;
import kit.item.domain.it.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity(name = "REPAIR_SERVICE_RESERVATION")
@ToString(callSuper = true)
public class RepairServiceReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_service_reservation_id", nullable = false)
    private Long id;
    private String etc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repair_service_id")
    @ToString.Exclude
    private RepairService repairService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    @ToString.Exclude
    private Reservation reservation;

    public void setRepairService(RepairService repairService) {
        this.repairService = repairService;
    }
}
