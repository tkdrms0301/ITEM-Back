package kit.item.domain.it;

import jakarta.persistence.*;
import kit.item.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity(name = "IT_DEVEICE")
@ToString(callSuper = true)
public class ItDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "it_device_id", nullable = false)
    private Long id;

    private Long registrationSeq;
    private String directlyRegisteredName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_product_id")
    @ToString.Exclude
    private BrandProduct brandProduct;

    public void setBrandProduct(BrandProduct brandProduct) {
        this.brandProduct = brandProduct;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
