package kit.item.domain.market;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity(name = "MARKET_REPLY")
@ToString(callSuper = true)
public class MarketReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "market_reply_id", nullable = false)
    private Long id;

    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    @ToString.Exclude
    private MarketReview marketReview;

    public void setMarketReview(MarketReview marketReview) {
        this.marketReview = marketReview;
    }
}
