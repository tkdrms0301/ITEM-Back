package kit.item.repository;

import kit.item.domain.member.RepairShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicRepository extends JpaRepository<RepairShop, Long> {
    @Modifying
    @Query("update REPAIR_SHOP r set " +
            "r.address=:address, r.nickname=:nickname, r.password=:password, r.name=:name, r.phoneNumber=:phoneNumber," +
            "r.shopName=:shopName, r.shopPhoneNumber=:shopPhoneNumber, r.description=:description" +
            " where r.id=:id")
    void updateMechanicById(@Param("address") String address,
                         @Param("nickname") String nickname,
                         @Param("password") String password,
                         @Param("name") String name,
                         @Param("phoneNumber") String phoneNumber,
                         @Param("shopName") String shopName,
                         @Param("shopPhoneNumber") String shopPhoneNumber,
                         @Param("description") String description,
                         @Param("id") Long id);
}
