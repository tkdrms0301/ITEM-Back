package kit.item.repository.market;

import kit.item.domain.market.MarketReview;
import kit.item.domain.market.MarketReviewReport;
import kit.item.dto.entity.market.ReportCountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketReviewReportRepository extends JpaRepository<MarketReviewReport,Long> {

    @Query("SELECT new kit.item.dto.entity.market.ReportCountDto(m.marketReview.id, count(*))" +
            "FROM MARKET_REVIEW_REPORT m " +
            "WHERE m.marketReview.id = :marketReviewId")
    ReportCountDto countBymarketReviewId(@Param("marketReviewId") Long marketReviewId);

    void deleteByMarketReview(MarketReview marketReview);

    MarketReviewReport findByMember_IdAndMarketReview_Id(Long memberId, Long marketReviewId);
}
