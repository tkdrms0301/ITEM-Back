package kit.item.domain.point;

import jakarta.persistence.*;
import kit.item.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity(name = "SUBSCRIPTION")
@ToString(callSuper = true)
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id", nullable = false)
    private Long id;
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    public Subscription(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
