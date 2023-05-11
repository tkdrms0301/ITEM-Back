package kit.item.domain.market;

import jakarta.persistence.*;
import kit.item.domain.member.Seller;
import kit.item.domain.it.BrandProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "SALE_PRODUCT")
@ToString(callSuper = true)
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_product_id", nullable = false)
    private Long id;

    private String name;
    private Integer cost;
    @Column(name = "delivery_cost")
    private Integer deliveryCost;
    @Column(name = "delivery_company")
    private Integer deliveryCompany;
    private String comment;
    @Column(name = "thumbnail_url")
    private String thumbnailUrl;
    private String kind;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    @ToString.Exclude
    private Seller seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_product_id")
    @ToString.Exclude
    private BrandProduct brandProduct;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "saleProduct")
    @ToString.Exclude
    private List<ImageDetail> imageDetails = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "saleProduct")
    @ToString.Exclude
    private List<Basket> baskets = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "saleProduct")
    @ToString.Exclude
    private List<MarketReview> marketReviews = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "saleProduct")
    @ToString.Exclude
    private List<SaleHistory> saleHistories = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "saleProduct")
    @ToString.Exclude
    private List<SaleProductReport> saleProductReports = new ArrayList<>();

    public void setSaleHistories(List<SaleHistory> saleHistories) {
        this.saleHistories = saleHistories;
    }

    public void setMarketReviews(List<MarketReview> marketReviews) {
        this.marketReviews = marketReviews;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public void setImageDetails(List<ImageDetail> imageDetails) {
        this.imageDetails = imageDetails;
    }

    public void setBrandProduct(BrandProduct brandProduct) {
        this.brandProduct = brandProduct;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
