package kit.item.domain.mysql.point;

import jakarta.persistence.*;
import kit.item.domain.mysql.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity(name = "POINT_HISTORY")
@ToString(callSuper = true)
public class PointHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_history_id", nullable = false)
    private Long id;
    @Column(name = "service_type")
    private String serviceType;
    @Column(name = "service_name")
    private String serviceName;
    private Long point;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }
}
