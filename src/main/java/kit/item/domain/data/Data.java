package kit.item.domain.data;

import jakarta.persistence.*;
import kit.item.domain.it.BrandProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity(name = "DATA")
@ToString(callSuper = true)
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_id", nullable = false)
    private Long id;
    private String vocab;
    private Long count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_product_id")
    @ToString.Exclude
    private BrandProduct brandProduct;

    public void setBrandProduct(BrandProduct brandProduct) {
        this.brandProduct = brandProduct;
    }
}
