package kit.item.domain.member;

import jakarta.persistence.*;
import kit.item.domain.market.*;
import kit.item.domain.it.ItDevice;
import kit.item.domain.point.PointHistory;
import kit.item.domain.point.Subscription;
import kit.item.domain.post.Comment;
import kit.item.domain.post.CommentReport;
import kit.item.domain.post.Post;
import kit.item.domain.post.PostReport;
import kit.item.domain.repair.Estimate;
import kit.item.domain.repair.RepairResultReport;
import kit.item.domain.repair.RepairServiceReview;
import kit.item.domain.repair.Reservation;
import kit.item.enums.RoleType;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "MEMBER")
@ToString(callSuper = true)
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    private String name;
    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    private Long point;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private RoleType roleType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<ItDevice> itDevices = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<PointHistory> pointHistories = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<Post> communities = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<Basket> baskets = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<MarketReview> marketReviews = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<SaleHistory> saleHistories = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<Estimate> estimates = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<RepairServiceReview> repairServiceReviews = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<SaleProductReport> saleProductReports = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<MarketReviewReport> marketReviewReports = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<PostReport> postReports = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<CommentReport> commentReports = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<RepairResultReport> repairResultReports = new ArrayList<>();

    @OneToOne(mappedBy = "member")
    @ToString.Exclude
    private Subscription subscription;

    public void setRepairServiceReviews(List<RepairServiceReview> repairServiceReviews) {
        this.repairServiceReviews = repairServiceReviews;
    }

    public void setEstimates(List<Estimate> estimates) {
        this.estimates = estimates;
    }

    public void setSaleHistories(List<SaleHistory> saleHistories) {
        this.saleHistories = saleHistories;
    }

    public void setMarketReviews(List<MarketReview> marketReviews) {
        this.marketReviews = marketReviews;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setCommunities(List<Post> communities) {
        this.communities = communities;
    }

    public void setPointHistories(List<PointHistory> pointHistories) {
        this.pointHistories = pointHistories;
    }

    public void setItDevices(List<ItDevice> itDevices) {
        this.itDevices = itDevices;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        //authorities.add(new SimpleGrantedAuthority("ROLE_" + roleType.name()));
        authorities.add(new SimpleGrantedAuthority(roleType.name()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
