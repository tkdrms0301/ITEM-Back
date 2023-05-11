package kit.item.domain.market;

import jakarta.persistence.*;
import kit.item.domain.member.Member;
import kit.item.enums.ReportType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity(name = "SALE_PRODUCT_REPORT")
@ToString(callSuper = true)
public class SaleProductReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_product_report_id", nullable = false)
    private Long id;
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_type")
    private ReportType reportType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_product_id")
    @ToString.Exclude
    private SaleProduct saleProduct;
}
