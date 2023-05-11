package kit.item.domain.mysql.repair;

import jakarta.persistence.*;
import kit.item.domain.mysql.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "ESTIMATE")
@ToString(callSuper = true)
public class Estimate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estimate_id", nullable = false)
    private Long id;

    private String description;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estimate")
    @ToString.Exclude
    private List<EstimateImage> estimateImages = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Response response;

    public void setResponse(Response response) {
        this.response = response;
    }

    public void setEstimateImages(List<EstimateImage> estimateImages) {
        this.estimateImages = estimateImages;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
