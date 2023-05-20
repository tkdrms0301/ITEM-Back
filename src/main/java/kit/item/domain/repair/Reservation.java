package kit.item.domain.repair;

import jakarta.persistence.*;
import kit.item.domain.it.ItDevice;
import kit.item.domain.member.Member;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "RESERVATION")
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false)
    private Long id;
    private LocalDateTime reservationDate;
    private LocalDateTime applicationDate;
    private String state;
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reservation")
    @ToString.Exclude
    private List<RepairResult> repairResults = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reservation")
    @ToString.Exclude
    private List<ReservationImage> reservationImages = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reservation")
    @ToString.Exclude
    private List<RepairServiceReservation> repairServiceReservations = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "it_device_id")
    @ToString.Exclude
    private ItDevice itDevice;

    public void setReservationImages(List<ReservationImage> reservationImages) {
        this.reservationImages = reservationImages;
    }

    public void setRepairReports(List<RepairResult> repairReports) {
        this.repairResults = repairReports;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
