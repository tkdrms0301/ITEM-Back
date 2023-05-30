package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairResultImage;
import kit.item.dto.entity.repairShop.RepairResultImageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairResultImageRepository extends JpaRepository<RepairResultImage, Long> {
    boolean existsByHash(String hash);

    @Query("select r.url " +
           "from REPAIR_RESULT_IMAGE r " +
           "where r.repairResult.id= :repairResultId and r.isBefore = :isBefore")
    List<String> findImagesByRepairResultId(
            @Param(value = "repairResultId") Long repairResultId,
            @Param(value = "isBefore") boolean isBefore);
}
