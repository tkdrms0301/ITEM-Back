package kit.item.repository.repairShop;

import kit.item.domain.repair.OfficialRepairShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficialRepairShopRepository  extends JpaRepository<OfficialRepairShop, Long> {

    List<OfficialRepairShop> findAll();
}
