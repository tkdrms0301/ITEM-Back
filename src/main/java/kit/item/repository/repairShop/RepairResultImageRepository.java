package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairResultImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairResultImageRepository extends JpaRepository<RepairResultImage, Long> {
    boolean existsByHash(String hash);
}
