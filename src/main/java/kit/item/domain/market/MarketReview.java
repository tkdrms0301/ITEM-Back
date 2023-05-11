package kit.item.domain.market;

import jakarta.persistence.*;
import kit.item.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "MARKET_REVIEW")
@ToString(callSuper = true)
public class MarketReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "market_review_id", nullable = false)
    private Long id;

    private Integer rating;
    private String comment;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_product_id")
    @ToString.Exclude
    private SaleProduct saleProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @OneToOne(mappedBy = "marketReview")
    @ToString.Exclude
    private MarketReply marketReply;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "marketReview")
    @ToString.Exclude
    private List<MarketReviewReport> marketReviewReports = new ArrayList<>();

    public void setMarketReply(MarketReply marketReply) {
        this.marketReply = marketReply;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setSaleProduct(SaleProduct saleProduct) {
        this.saleProduct = saleProduct;
    }
}
