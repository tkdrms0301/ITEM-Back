package kit.item.repository.repairShop;

import kit.item.domain.repair.EstimateImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstimateImageRepository extends JpaRepository<EstimateImage, Long> {
    EstimateImage findByEstimateId(Long estimateId);
}
