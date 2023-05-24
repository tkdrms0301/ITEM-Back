package kit.item.domain.repair;

import jakarta.persistence.*;
import kit.item.domain.member.RepairShop;
import kit.item.enums.ServiceType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "REPAIR_SERVICE")
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
public class RepairService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_service_id", nullable = false)
    private Long id;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_type", nullable = false)
    private ServiceType serviceType;

    @Column(name = "service_price", nullable = false)
    private Long price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repair_shop_id")
    @ToString.Exclude
    private RepairShop repairShop;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairService")
    @ToString.Exclude
    private List<RepairServiceReservation> repairServiceReservations = new ArrayList<>();

    public void setRepairShop(RepairShop repairShop) {
        this.repairShop = repairShop;
    }
}
