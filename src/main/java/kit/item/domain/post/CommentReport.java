package kit.item.domain.post;

import jakarta.persistence.*;
import kit.item.domain.member.Member;
import kit.item.enums.ReportType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "COMMENT_REPORT")
@ToString(callSuper = true)
public class CommentReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_report_id", nullable = false)
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
    @JoinColumn(name = "comment_id")
    @ToString.Exclude
    private Comment comment;
}
