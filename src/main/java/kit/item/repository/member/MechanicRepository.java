package kit.item.repository.member;

import kit.item.domain.member.RepairShop;
import kit.item.enums.RepairServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicRepository extends JpaRepository<RepairShop, Long> {
    @Modifying
    @Query("update REPAIR_SHOP r set " +
            "r.address=:address, r.nickname=:nickname, r.password=:password, r.phoneNumber=:phoneNumber, r.account=:account, " +
            "r.shopName=:shopName, r.shopPhoneNumber=:shopPhoneNumber, r.description=:description, r.repairServiceType=:repairServiceType " +
            "where r.id=:id")
    void updateMechanicById(@Param("address") String address,
                         @Param("nickname") String nickname,
                         @Param("password") String password,
                         @Param("phoneNumber") String phoneNumber,
                         @Param("account") String account,
                         @Param("shopName") String shopName,
                         @Param("shopPhoneNumber") String shopPhoneNumber,
                         @Param("description") String description,
                         @Param("repairServiceType") RepairServiceType repairServiceType,
                         @Param("id") Long id);
}
