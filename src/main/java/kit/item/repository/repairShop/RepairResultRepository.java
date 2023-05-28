package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairResultRepository extends JpaRepository<RepairResult, Long> {

}
