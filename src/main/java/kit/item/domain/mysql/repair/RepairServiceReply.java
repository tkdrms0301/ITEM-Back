package kit.item.domain.mysql.repair;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity(name = "REPAIR_SERVICE_REPLY")
@ToString(callSuper = true)
public class RepairServiceReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id", nullable = false)
    private Long id;
    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    @ToString.Exclude
    private RepairServiceReview repairServiceReview;

    public void setRepairServiceReview(RepairServiceReview repairServiceReview) {
        this.repairServiceReview = repairServiceReview;
    }
}
