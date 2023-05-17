package kit.item.domain.repair;

import jakarta.persistence.*;
import kit.item.domain.member.RepairShop;
import kit.item.enums.ServiceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "REPAIR_SERVICE")
@ToString(callSuper = true)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repair_shop_id")
    @ToString.Exclude
    private RepairShop repairShop;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairService")
    @ToString.Exclude
    private List<RepairServiceReservation> repairServiceReservations = new ArrayList<>();

    public void setRepairServiceReservations(List<RepairServiceReservation> repairServiceReservations) {
        this.repairServiceReservations = repairServiceReservations;
    }

    public void setRepairShop(RepairShop repairShop) {
        this.repairShop = repairShop;
    }
}
