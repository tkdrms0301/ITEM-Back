package kit.item.domain.market;


import jakarta.persistence.*;
import kit.item.domain.member.Member;
import kit.item.enums.ReportType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor
@Entity(name = "MARKET_REVIEW_REPORT")
@ToString(callSuper = true)
public class MarketReviewReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "market_review_report_id", nullable = false)
    private Long id;
    private String reason;

    @Enumerated(EnumType.STRING)
    private ReportType reportType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_review_id")
    @ToString.Exclude
    private MarketReview marketReview;
}
