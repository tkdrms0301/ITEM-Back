package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairServiceReply;
import kit.item.dto.entity.repairShop.RepairServiceReplyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepairServiceReplyRepository extends JpaRepository<RepairServiceReply, Long> {
    boolean existsByRepairShopIdAndId(Long shopId, Long reviewId);

    @Query("select new kit.item.dto.entity.repairShop.RepairServiceReplyDto(r.id, r.content) " +
            "from REPAIR_SERVICE_REPLY r " +
            "where r.id = :reviewId")
    RepairServiceReplyDto findByReviewId(Long reviewId);
}
