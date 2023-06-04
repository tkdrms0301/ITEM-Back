package kit.item.repository.market;

import kit.item.domain.market.MarketReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarketReviewRepository extends JpaRepository<MarketReview, Long>{

    Optional<MarketReview> findByIdAndMember_Id(Long id, Long memberId);
    List<MarketReview> findBySaleProduct_Id(Long saleProductId);

    MarketReview findByMember_IdAndSaleProduct_Id(Long memberId, Long saleProductId);
}
