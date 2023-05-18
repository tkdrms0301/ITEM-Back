package kit.item.domain.it;

import jakarta.persistence.*;
import kit.item.domain.data.PosAndNeg;
import kit.item.enums.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;

    @Column(name = "product_name")
    private String name;

    /*
     * 완제품 COMPLETE_PRODUCT
     * 완본체 FINISHED_PRODUCT
     * 부품 COMPONENT
     */
    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<PosAndNeg> posAndNegs = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ItDevice> itDevices = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kind_id")
    private Kind kind;
}
