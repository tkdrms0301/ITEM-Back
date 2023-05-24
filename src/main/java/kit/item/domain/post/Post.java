package kit.item.domain.post;

import jakarta.persistence.*;
import kit.item.domain.it.Product;
import kit.item.domain.member.Member;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "POST")
@ToString(callSuper = true)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Long id;

    private String title;
    private String content;
    private LocalDateTime date;
    private Long report;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;

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

    public void setMember(Member member) {
        this.member = member;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
