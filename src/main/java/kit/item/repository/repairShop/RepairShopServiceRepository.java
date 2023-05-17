package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairShopServiceRepository extends JpaRepository<RepairService, Long> {

    List<RepairService> findAll();

    List<RepairService> findByRepairShopId(Long repairShopId);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM REPAIR_SERVICE p WHERE p.repairShop.id = :memberId AND p.id = :serviceId")
    boolean existsByMemberIdAndServiceId(@Param("memberId") Long memberId, @Param("serviceId") Long serviceId);

}
