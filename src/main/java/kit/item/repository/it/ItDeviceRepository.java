package kit.item.repository.it;

import kit.item.domain.it.ItDevice;
import kit.item.dto.entity.device.DeviceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItDeviceRepository extends JpaRepository<ItDevice, Long> {

    @Query("select new kit.item.dto.entity.device.DeviceDto(" +
            "i.id, i.category.id, i.brand.id, i.product.id, i.category.name, i.brand.name, i.product.name, i.directlyRegisteredName, i.category.imageUrl) " +
            "from IT_DEVICE i where i.member.id =:memberId and i.category.id =:categoryId " +
            "and i.category.isPart = false")
    List<DeviceDto> findSelectDeviceByMemberId(@Param(value = "memberId") Long memberId, @Param(value = "categoryId") Long categoryId);

    @Query("select new kit.item.dto.entity.device.DeviceDto(" +
            "i.id, i.category.id, i.brand.id, i.product.id, i.category.name, i.brand.name, i.product.name, i.directlyRegisteredName, i.category.imageUrl) " +
            "from IT_DEVICE i where i.member.id =:memberId and i.finishedProduct.id =:deviceId")
    List<DeviceDto> findSelectComponentByMemberIdAndComponentProductId(@Param(value = "memberId") Long memberId, @Param(value = "deviceId") Long deviceId);

    @Query("delete from IT_DEVICE i where i.member.id =:memberId and i.finishedProduct.id =:deviceId")
    void deletePartProductsByFinishedProductId(@Param(value = "memberId") Long memberId,@Param(value = "deviceId") Long finishedProductId);
    List<ItDevice> findByComponentProductId(Long componentProductId);

    @Query("SELECT new kit.item.dto.entity.device.DeviceDto(" +
            "i.id, i.category.id, i.brand.id, i.product.id, i.member.id, i.category.name, i.brand.name, i.product.name, i.directlyRegisteredName, i.product.productType, i.category.imageUrl) " +
            "FROM IT_DEVICE i WHERE i.member.id = :memberId")
    List<DeviceDto> findDeviceByMemberId(@Param(value = "memberId") Long memberId);

    @Query("SELECT i FROM IT_DEVICE i WHERE i.member.id = :memberId AND (i.directlyRegisteredName IS NULL AND i.product.name = :productName OR i.directlyRegisteredName = :productName)")
    ItDevice findDeviceByMemberIdAndProductName(@Param("memberId") Long memberId, @Param("productName") String productName);
}
