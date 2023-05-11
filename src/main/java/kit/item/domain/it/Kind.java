package kit.item.domain.it;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "KIND")
public class Kind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kind_id", nullable = false)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "kind")
    private List<Product> products = new ArrayList<>();
}
