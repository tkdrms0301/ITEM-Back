package kit.item.domain.repair;

import jakarta.persistence.*;
import kit.item.domain.member.RepairShop;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repair_shop_id")
    private RepairShop repairShop;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairServiceReply")
    @ToString.Exclude
    private List<RepairServiceReplyReport> repairServiceReplyReports = new ArrayList<>();
}
