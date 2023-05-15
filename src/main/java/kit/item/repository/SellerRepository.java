package kit.item.repository;

import kit.item.domain.member.Seller;
import kit.item.dto.entity.member.SellerInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    @Modifying
    @Query("update SELLER s set " +
            "s.address=:address, s.nickname=:nickname, s.password=:password, s.name=:name, s.phoneNumber=:phoneNumber," +
            "s.companyAddress=:companyAddress, s.companyPhoneNumber=:companyPhoneNumber, s.companyName=:companyName, s.companyNumber=:companyNumber, s.description=:description" +
            " where s.id=:id")
    int updateMechanicById(@Param("address") String address,
                           @Param("nickname") String nickname,
                           @Param("password") String password,
                           @Param("name") String name,
                           @Param("phoneNumber") String phoneNumber,
                           @Param("companyAddress") String companyAddress,
                           @Param("companyPhoneNumber") String companyPhoneNumber,
                           @Param("companyName") String companyName,
                           @Param("companyNumber") String companyNumber,
                           @Param("description") String description,
                           @Param("id") Long id);
}
