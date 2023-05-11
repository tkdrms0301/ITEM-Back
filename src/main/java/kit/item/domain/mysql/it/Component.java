package kit.item.domain.mysql.it;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "COMPONENT")
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "product_id", name = "complete_product_id", insertable = false, updatable = false)
    private Product completeProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "product_id", name = "part_product_id", insertable = false, updatable = false)
    private Product partProduct;
}
