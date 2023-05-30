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

    @Query("select new kit.item.dto.entity.repairShop.RepairServiceReviewDto(r.id, r.content, r.rating, rep.id, rep.content, r.member.nickname, rep.repairShop.nickname) " +
            "from REPAIR_SERVICE_REVIEW r " +
            "LEFT join fetch REPAIR_SERVICE_REPLY rep " +
            "on r.id = rep.repairServiceReview.id " +
            "where r.repairShop.id = :shopId")
    Page<RepairServiceReviewDto> findAllByRepairShopId(@Param(value = "shopId") Long shopId, Pageable page);
}
