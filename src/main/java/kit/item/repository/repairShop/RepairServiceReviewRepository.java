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
    @Query("SELECT new kit.item.dto.entity.repairShop.RepairServiceReviewDto(rw.id, rw.content, rw.rating, rr.id, rr.content, m.nickname, rs.nickname) " +
            "FROM REPAIR_SERVICE_REVIEW rw " +
            "LEFT JOIN REPAIR_SERVICE_REPLY rr ON rw.id = rr.repairServiceReview.id " +
            "LEFT JOIN rw.member m " +
            "LEFT JOIN rr.repairShop rs " +
            "where rw.repairShop.id = :shopId")
    Page<RepairServiceReviewDto> findAllByRepairShopId(@Param(value = "shopId") Long shopId, Pageable page);

    Optional<RepairServiceReview> findByIdAndMember_Id(Long id, Long memberId);
}
