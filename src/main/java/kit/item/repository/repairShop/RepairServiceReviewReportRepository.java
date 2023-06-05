package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairServiceReview;
import kit.item.domain.repair.RepairServiceReviewReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepairServiceReviewReportRepository extends JpaRepository<RepairServiceReviewReport, Long> {
    Optional<RepairServiceReviewReport> findByRepairServiceReviewIdAndMemberId(Long reviewId, Long memberId);

    @Query("SELECT COUNT(r) FROM REPAIR_SERVICE_REVIEW_REPORT r " +
            "WHERE r.repairServiceReview.id = :reviewId AND r.member.id = :memberId")
    int countByRepairServiceReviewIdAndMemberId(@Param(value = "reviewId") Long repairServiceReview_id,
                                                @Param(value = "memberId") Long member_id);

    List<RepairServiceReviewReport> findAllByRepairServiceReviewId(Long reviewId);
}
