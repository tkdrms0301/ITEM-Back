package kit.item.domain.repair;

import jakarta.persistence.*;
import kit.item.domain.member.Member;
import kit.item.domain.member.RepairShop;
import lombok.*;
import org.springframework.lang.Nullable;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "REPAIR_SERVICE_REVIEW")
@ToString(callSuper = true)
public class RepairServiceReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private Long id;
    private String content;
    private Long rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repair_shop_id")
    @ToString.Exclude
    private RepairShop repairShop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @OneToOne(mappedBy = "repairServiceReview")
    @ToString.Exclude
    private RepairServiceReply repairServiceReply;

    public void setRepairServiceReply(RepairServiceReply repairServiceReply) {
        this.repairServiceReply = repairServiceReply;
    }
}
