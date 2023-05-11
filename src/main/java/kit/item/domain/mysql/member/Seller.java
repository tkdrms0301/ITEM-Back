package kit.item.domain.mysql.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import kit.item.domain.mysql.market.SaleProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "SELLER")
@ToString(callSuper = true)
public class Seller extends Member{
    @Column(name = "company_number")
    private Long companyNumber;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_phone_number")
    private String companyPhoneNumber;
    private String description;
    @Column(name = "shop_address")
    private String shopAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
    @ToString.Exclude
    private List<SaleProduct> saleProducts = new ArrayList<>();

    public void setSaleProducts(List<SaleProduct> saleProducts) {
        this.saleProducts = saleProducts;
    }
}
