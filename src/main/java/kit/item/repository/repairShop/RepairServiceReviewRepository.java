package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairServiceReview;
import kit.item.dto.entity.repairShop.RepairServiceReviewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepairServiceReviewRepository extends JpaRepository<RepairServiceReview, Long> {
    Optional<RepairServiceReview> findByRepairShopIdAndMemberId(Long shopId, Long memberId);
    boolean existsByMemberIdAndRepairShopId(Long memberId, Long shopId);

    @Query("select new kit.item.dto.entity.repairShop.RepairServiceReviewDto(r.id, r.content, r.rating) " +
            "from REPAIR_SERVICE_REVIEW r " +
            "where r.repairShop.id = :shopId")
    Page<RepairServiceReviewDto> findByRepairShopId(@Param(value = "shopId") Long shopId, Pageable page);

    Page<RepairServiceReview> findAllByRepairShopId(Long shopId, Pageable page);
}
