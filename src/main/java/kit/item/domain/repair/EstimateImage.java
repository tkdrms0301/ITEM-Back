package kit.item.domain.repair;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity(name = "ESTIMATE_IMAGE")
@ToString(callSuper = true)
public class EstimateImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estimate_image_id", nullable = false)
    private Long imageId;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estimate_id")
    @ToString.Exclude
    private Estimate estimate;

    public void setEstimate(Estimate estimate) {
        this.estimate = estimate;
    }
}
