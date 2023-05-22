package kit.item.domain.it;

import jakarta.persistence.*;
import kit.item.domain.data.Data;
import kit.item.domain.data.PosAndNeg;
import kit.item.domain.market.SaleProduct;
import kit.item.domain.post.Post;
import kit.item.domain.repair.RepairServiceReservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "directly_register_product_name")
    private String directlyRegisterProductName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_brand_id")
    private CategoryBrand categoryBrand;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<PosAndNeg> posAndNegs = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ItDevice> itDevices = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Data> datas = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Post> communities = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<SaleProduct> saleProducts = new ArrayList<>();


}
