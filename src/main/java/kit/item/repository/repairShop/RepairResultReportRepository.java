package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairResultReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairResultReportRepository extends JpaRepository<RepairResultReport, Long> {

}
