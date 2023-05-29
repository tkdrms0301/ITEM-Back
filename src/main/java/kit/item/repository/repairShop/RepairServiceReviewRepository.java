package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairServiceReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepairServiceReviewRepository extends JpaRepository<RepairServiceReview, Long> {
    Optional<RepairServiceReview> findByRepairShopIdAndMemberId(Long repairShop_id, Long member_id);
}
