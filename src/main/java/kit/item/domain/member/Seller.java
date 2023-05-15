package kit.item.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import kit.item.domain.market.SaleProduct;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SELLER")
@ToString(callSuper = true)
public class Seller extends Member{
    @Column(name = "company_number")
    private String companyNumber;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_phone_number")
    private String companyPhoneNumber;
    private String description;
    @Column(name = "company_address")
    private String companyAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
    @ToString.Exclude
    private List<SaleProduct> saleProducts = new ArrayList<>();

    public void setSaleProducts(List<SaleProduct> saleProducts) {
        this.saleProducts = saleProducts;
    }
}
