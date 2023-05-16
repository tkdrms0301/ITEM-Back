package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairShopServiceRepository extends JpaRepository<RepairService, Long> {

    List<RepairService> findAll();

    List<RepairService> findByRepairShopId(Long repairShopId);
}
