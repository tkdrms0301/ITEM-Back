package kit.item.domain.mysql.it;

import jakarta.persistence.*;
import kit.item.domain.mysql.data.Data;
import kit.item.domain.mysql.market.SaleProduct;
import kit.item.domain.mysql.post.Post;
import kit.item.domain.mysql.repair.RepairServiceReservation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "BRAND_PRODUCT")
public class BrandProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_product_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brandProduct")
    private List<ItDevice> itDevices = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brandProduct")
    private List<Data> datas = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brandProduct")
    private List<Post> communities = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brandProduct")
    private List<SaleProduct> saleProducts = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brandProduct")
    private List<RepairServiceReservation> repairServiceReservations = new ArrayList<>();
}
