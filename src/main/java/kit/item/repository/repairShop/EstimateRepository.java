package kit.item.repository.repairShop;

import kit.item.domain.repair.Estimate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstimateRepository extends JpaRepository<Estimate, Long> {

    Optional<Estimate> findByIdAndRepairShopId(Long id, Long repairShopId);

    List<Estimate> findByMemberId(Long memberId);

    List<Estimate> findByRepairShopId(Long repairShopId);
}
