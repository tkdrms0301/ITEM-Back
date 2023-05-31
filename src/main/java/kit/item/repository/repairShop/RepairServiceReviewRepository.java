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
    @Query(value = "select rw.review_id, rw.content, rw.rating, rr.reply_id, rr.content, m.nickname, m2.nickname " +
            "from repair_service_review rw " +
            "left join repair_service_reply rr on rw.review_id = rr.review_id " +
            "left join member m on rw.member_id = m.member_id " +
            "left join repair_shop rs on rs.member_id = rr.repair_shop_id " +
            "left join member m2 on rs.member_id = m2.member_id ", nativeQuery = true)
    Page<Object> findAllByRepairShopIdV2(@Param(value = "shopId") Long shopId, Pageable page);

    @Query("SELECT new kit.item.dto.entity.repairShop.RepairServiceReviewDto(rw.id, rw.content, rw.rating, rr.id, rr.content, m.nickname, rs.nickname) " +
            "FROM REPAIR_SERVICE_REVIEW rw " +
            "LEFT JOIN REPAIR_SERVICE_REPLY rr ON rw.id = rr.repairServiceReview.id " +
            "LEFT JOIN rw.member m " +
            "LEFT JOIN rr.repairShop rs ")
    Page<RepairServiceReviewDto> findAllByRepairShopId(@Param(value = "shopId") Long shopId, Pageable page);
}
