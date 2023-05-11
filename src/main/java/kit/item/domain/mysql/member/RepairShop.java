package kit.item.domain.mysql.member;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import kit.item.domain.mysql.repair.RepairService;
import kit.item.domain.mysql.repair.RepairServiceReview;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "REPAIR_SHOP")
@ToString(callSuper = true)
public class RepairShop extends Member{
    private String shopName;
    private String shopPhoneNumber;
    private String description;

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
