package kit.item.domain.mysql.repair;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity(name = "OFFICIAL_REPAIR_SHOP")
@ToString(callSuper = true)
public class OfficialRepairShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "official_repair_shop_id", nullable = false)
    private Long id;
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String description;
}
