package kit.item.domain.repair;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity(name = "RESERVATION_IMAGE")
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
public class ReservationImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_image_id", nullable = false)
    private Long id;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    @ToString.Exclude
    private Reservation reservation;

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
