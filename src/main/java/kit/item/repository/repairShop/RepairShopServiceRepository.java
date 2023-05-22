package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairService;
import kit.item.enums.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    @Modifying
    @Query("UPDATE REPAIR_SERVICE rs SET rs.serviceType = :serviceType, rs.serviceName = :serviceName, rs.description = :description, rs.price = :price WHERE rs.id = :serviceId")
    void updateServiceDetails(@Param("serviceId") Long serviceId
            , @Param("serviceType") ServiceType serviceType
            , @Param("serviceName") String serviceName
            , @Param("description") String description
            , @Param("price") Long price);

    @Query("SELECT rs FROM REPAIR_SERVICE rs WHERE rs.serviceName = :serviceName AND rs.repairShop.id = :repairShopId")
    List<RepairService> findByServiceNameAndRepairShopId(@Param("serviceName") String serviceName, @Param("repairShopId") Long repairShopId);

}
