package kit.item.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import kit.item.domain.repair.RepairService;
import kit.item.domain.repair.RepairServiceReview;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "REPAIR_SHOP")
@ToString(callSuper = true)
public class RepairShop extends Member{
    private String shopName;
    private String shopPhoneNumber;
    private String description;
    @Column(name = "shop_address")
    private String shopAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairShop")
    @ToString.Exclude
    private List<RepairService> repairServices = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairShop")
    @ToString.Exclude
    private List<RepairServiceReview> repairServiceReviews = new ArrayList<>();

    public void setRepairServices(List<RepairService> repairServices) {
        this.repairServices = repairServices;
    }
}
