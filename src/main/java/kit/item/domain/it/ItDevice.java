package kit.item.domain.it;

import jakarta.persistence.*;
import kit.item.domain.member.Member;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "IT_DEVICE")
public class ItDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "it_device_id", nullable = false)
    private Long id;
    @Column(name = "directly_registered_name")
    private String directlyRegisteredName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    @ToString.Exclude
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finished_it_device_id")
    @ToString.Exclude
    private ItDevice finishedProduct;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "finishedProduct", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ItDevice> components;


    public void setMember(Member member) {
        this.member = member;
    }
}
