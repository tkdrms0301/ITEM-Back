package kit.item.domain.repair;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity(name = "RESPONSE")
@ToString(callSuper = true)
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reponse_id", nullable = false)
    private Long id;
    private String comment;
    @Column(name = "cost_min")
    private Integer costMin;
    @Column(name = "cost_max")
    private Integer costMax;
    private Integer duration;
    @Column(name = "response_date")
    private LocalDateTime responseDate;

    @OneToOne(mappedBy = "response")
    @ToString.Exclude
    private Estimate estimate;

    public void setEstimate(Estimate estimate) {
        this.estimate = estimate;
    }
}
