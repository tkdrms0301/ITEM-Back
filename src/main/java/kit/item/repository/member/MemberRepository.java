package kit.item.repository.member;

import kit.item.domain.member.Member;
import kit.item.dto.entity.member.MechanicInfoDto;
import kit.item.dto.entity.member.MemberInfoDto;
import kit.item.dto.entity.member.MemberLoginInfoDto;
import kit.item.dto.entity.member.SellerInfoDto;
import kit.item.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByRoleType(RoleType roleType);

    Optional<Member> findByEmail(String email);

    //@Query("select m from MEMBER m where m.email like :email")
    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    boolean existsByEmailAndIdNot(String email, Long memberId);

    boolean existsByNicknameAndIdNot(String nickname, Long memberId);

    @Query("select new kit.item.dto.entity.member.MemberLoginInfoDto(m.nickname, m.roleType) from MEMBER m where m.email like :email")
    Optional<MemberLoginInfoDto> findMemberInfoByEmail(@Param("email") String email);

    @Query("select new kit.item.dto.entity.member.MemberInfoDto(m.id, m.email, m.password, m.name, m.nickname, m.phoneNumber, m.address, m.account, m.point, m.roleType, s.endDate) " +
            "from MEMBER m left join fetch SUBSCRIPTION s on m.id=s.member.id " +
            "where m.id=:id")
    Optional<MemberInfoDto> findMemberById(@Param("id") Long id);

    @Query("select new kit.item.dto.entity.member.MechanicInfoDto(r.description, r.shopName, r.shopPhoneNumber, r.shopAddress, r.repairServiceType) from MEMBER m join fetch REPAIR_SHOP r on r.id = m.id where m.id=:id")
    Optional<MechanicInfoDto> findMechanicById(@Param("id") Long id);

    @Query("select new kit.item.dto.entity.member.SellerInfoDto(s.companyName, s.companyNumber, s.companyPhoneNumber, s.description, s.companyAddress) from MEMBER m join fetch SELLER s on s.id = m.id where m.id=:id")
    Optional<SellerInfoDto> findSellerById(@Param("id") Long id);

    @Modifying
    @Query("update MEMBER m set m.address=:address, m.nickname=:nickname, m.password=:password, m.phoneNumber=:phoneNumber, m.account=:account where m.id=:id")
    void updateMemberById(@Param("address") String address,
                         @Param("nickname") String nickname,
                         @Param("password") String password,
                         @Param("phoneNumber") String phoneNumber,
                         @Param("account") String account,
                         @Param("id") Long id);
}
