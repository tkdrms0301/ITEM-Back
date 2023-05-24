package kit.item.domain.it;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long id;

    @Column(name = "category_name")
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "is_part")
    boolean isPart;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<CategoryBrand> categoryBrands = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<ItDevice> itDevices = new ArrayList<>();
}
