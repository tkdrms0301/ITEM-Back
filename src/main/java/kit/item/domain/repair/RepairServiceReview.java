package kit.item.domain.repair;

import jakarta.persistence.*;
import kit.item.domain.member.Member;
import kit.item.domain.member.RepairShop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity(name = "REPAIR_SERVICE_REVIEW")
@ToString(callSuper = true)
public class RepairServiceReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private Long id;
    private String content;

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

    public void setMember(Member member) {
        this.member = member;
    }

    public void setRepairShop(RepairShop repairShop) {
        this.repairShop = repairShop;
    }
}
