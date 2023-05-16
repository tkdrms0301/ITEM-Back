package kit.item.repository;

import kit.item.domain.member.Member;
import kit.item.dto.entity.member.MechanicInfoDto;
import kit.item.dto.entity.member.MemberInfoDto;
import kit.item.dto.entity.member.MemberLoginInfoDto;
import kit.item.dto.entity.member.SellerInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);

    @Query("select new kit.item.dto.entity.member.MemberLoginInfoDto(m.nickname, m.roleType) from MEMBER m where m.email like :email")
    Optional<MemberLoginInfoDto> findMemberInfoByEmail(@Param("email") String email);

    @Query("select new kit.item.dto.entity.member.MemberInfoDto(m.id, m.email, m.password, m.name, m.nickname, m.phoneNumber, m.address, m.account, m.point, m.roleType) from MEMBER m where m.id=:id")
    Optional<MemberInfoDto> findMemberById(@Param("id") Long id);

    @Query("select new kit.item.dto.entity.member.MechanicInfoDto(r.description, r.shopName, r.shopPhoneNumber) from MEMBER m join fetch REPAIR_SHOP r where m.id=:id")
    Optional<MechanicInfoDto> findMechanicById(@Param("id") Long id);

    @Query("select new kit.item.dto.entity.member.SellerInfoDto(s.companyName, s.companyNumber, s.companyPhoneNumber, s.description, s.companyAddress) from MEMBER m join fetch SELLER s where m.id=:id")
    Optional<SellerInfoDto> findSellerById(@Param("id") Long id);

    @Modifying
    @Query("update MEMBER m set m.address=:address, m.nickname=:nickname, m.password=:password, m.name=:name, m.phoneNumber=:phoneNumber, m.account=:account where m.id=:id")
    void updateMemberById(@Param("address") String address,
                         @Param("nickname") String nickname,
                         @Param("password") String password,
                         @Param("name") String name,
                         @Param("phoneNumber") String phoneNumber,
                         @Param("account") String account,
                         @Param("id") Long id);
}
