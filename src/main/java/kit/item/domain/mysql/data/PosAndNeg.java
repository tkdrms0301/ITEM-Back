package kit.item.domain.mysql.data;

import jakarta.persistence.*;
import kit.item.domain.mysql.it.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity(name = "POS_AND_NEG")
@ToString(callSuper = true)
public class PosAndNeg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pos_and_neg_id", nullable = false)
    private Long id;
    private Long positive;
    private Long negative;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }
}
