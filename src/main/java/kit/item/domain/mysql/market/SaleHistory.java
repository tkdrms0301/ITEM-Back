package kit.item.domain.mysql.market;

import jakarta.persistence.*;
import kit.item.domain.mysql.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity(name = "SALE_HISTORY")
@ToString(callSuper = true)
public class SaleHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_history_id", nullable = false)
    private Long id;

    private Integer amount;
    private LocalDateTime date;
    private String state;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_product_id")
    @ToString.Exclude
    private SaleProduct saleProduct;

    public void setSaleProduct(SaleProduct saleProduct) {
        this.saleProduct = saleProduct;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
