package kit.item.repository.market;

import kit.item.domain.market.MarketReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketReviewRepository extends JpaRepository<MarketReview, Long>{
    List<MarketReview> findBySaleProduct_Id(Long saleProductId);

    MarketReview findByMember_IdAndSaleProduct_Id(Long memberId, Long saleProductId);
}
