package kit.item.domain.repair;

import jakarta.persistence.*;
import kit.item.domain.it.ItDevice;
import kit.item.domain.member.Member;
import kit.item.domain.member.RepairShop;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "ESTIMATE")
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
public class Estimate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estimate_id", nullable = false)
    private Long id;

    private String description;
    private LocalDateTime date;
    private String state;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estimate")
    @ToString.Exclude
    private List<EstimateImage> estimateImages = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "it_device_id")
    @ToString.Exclude
    private ItDevice itDevice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repair_shop_id")
    @ToString.Exclude
    private RepairShop repairShop;

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

    public void setState(String state) {
        this.state = state;
    }
}
