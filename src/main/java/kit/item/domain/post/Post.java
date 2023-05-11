package kit.item.domain.post;

import jakarta.persistence.*;
import kit.item.domain.member.Member;
import kit.item.domain.it.BrandProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "POST")
@ToString(callSuper = true)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Long id;

    private String content;
    private LocalDateTime date;
    private Long report;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_product_id")
    @ToString.Exclude
    private BrandProduct brandProduct;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    @ToString.Exclude
    private List<PostImage> postImages = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    @ToString.Exclude
    private List<PostReport> postReports = new ArrayList<>();

    public void setPostImages(List<PostImage> postImages) {
        this.postImages = postImages;
    }

    public void setBrandProduct(BrandProduct brandProduct) {
        this.brandProduct = brandProduct;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
