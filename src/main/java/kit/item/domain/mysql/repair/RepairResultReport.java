package kit.item.domain.mysql.repair;

import jakarta.persistence.*;
import kit.item.domain.mysql.member.Member;
import kit.item.enums.ReportType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity(name = "REPAIR_RESULT_REPORT")
@ToString(callSuper = true)
public class RepairResultReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_result_report_id", nullable = false)
    private Long id;
    private String reason;

    @Enumerated(EnumType.STRING)
    private ReportType reportType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repair_result_id")
    @ToString.Exclude
    private RepairResult repairResult;
}
