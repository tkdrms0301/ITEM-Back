package kit.item.domain.mysql.market;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity(name = "PRODUCT_IMAGE_DETAIL")
@ToString(callSuper = true)
public class ImageDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_detail_id", nullable = false)
    private Long id;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_product_id")
    @ToString.Exclude
    private SaleProduct saleProduct;

    public void setSaleProduct(SaleProduct saleProduct) {
        this.saleProduct = saleProduct;
    }
}
