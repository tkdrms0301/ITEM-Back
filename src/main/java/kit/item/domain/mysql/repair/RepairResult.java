package kit.item.domain.mysql.repair;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "REPAIR_RESULT")
@ToString(callSuper = true)
public class RepairResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_result_id", nullable = false)
    private Long id;
    private Long total;
    private String comment;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    @ToString.Exclude
    private Reservation reservation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairResult")
    @ToString.Exclude
    private List<RepairResultImage> repairResultImages = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairResult")
    @ToString.Exclude
    private List<RepairResultReport> repairResultReports = new ArrayList<>();

    public void setRepairResultImages(List<RepairResultImage> repairResultImages) {
        this.repairResultImages = repairResultImages;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
