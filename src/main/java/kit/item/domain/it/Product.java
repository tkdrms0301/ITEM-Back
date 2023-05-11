package kit.item.domain.it;

import jakarta.persistence.*;
import kit.item.domain.data.PosAndNeg;
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

    /* true : 완제품, false : 부품 */
    @Column(name = "role_type")
    private boolean role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "completeProduct")
    private List<Component> completeComponents = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partProduct")
    private List<Component> partComponents = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<PosAndNeg> posAndNegs = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kind_id")
    private Kind kind;
}
