package kit.item.domain.h2;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "REFRESH_TOKEN")
@ToString(callSuper = true)
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refresh_id")
    private Long id;
    @Column(unique = true)
    private String email;
    private String token;
}
