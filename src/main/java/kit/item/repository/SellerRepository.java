package kit.item.repository;

import kit.item.domain.member.Seller;
import kit.item.dto.entity.member.SellerInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    @Query("select new kit.item.dto.entity.member.SellerInfoDto(s.companyName, s.companyNumber, s.companyPhoneNumber, s.description, s.companyAddress) from SELLER s where s.id=:id")
    Optional<SellerInfoDto> findSellerByMemberId(@Param("id") Long id);

//    @Query("select new kit.item.dto.entity.member.SellerInfoDto(m.email, m.password, m.name, m.nickname, m.phoneNumber, m.address, m.point, m.roleType, s.companyName, s.companyNumber, s.companyPhoneNumber, s.description, s.companyAddress) from SELLER s join fetch MEMBER m where m.id=:id")
//    Optional<SellerInfoDto> findSellerByMemberId(@Param("id") Long id);
}
