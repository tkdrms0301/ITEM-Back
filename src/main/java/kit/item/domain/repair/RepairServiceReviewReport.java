package kit.item.domain.repair;

import jakarta.persistence.*;
import kit.item.domain.member.Member;
import kit.item.enums.ReportType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "REPAIR_SERVICE_REVIEW_REPORT")
@ToString(callSuper = true)
public class RepairServiceReviewReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_service_review_report_id", nullable = false)
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
    @JoinColumn(name = "review_id")
    @ToString.Exclude
    private RepairServiceReview repairServiceReview;
}
