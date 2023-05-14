package kit.item.repository;

import kit.item.domain.member.Member;
import kit.item.dto.entity.member.MemberInfoDto;
import kit.item.dto.entity.member.MemberLoginInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);

    @Query("select new kit.item.dto.entity.member.MemberLoginInfoDto(m.id, m.nickname, m.roleType) from MEMBER m where m.email like :email")
    Optional<MemberLoginInfoDto> findMemberInfoByEmail(@Param("email") String email);

    @Query("select new kit.item.dto.entity.member.MemberInfoDto(m.id, m.email, m.password, m.name, m.nickname, m.phoneNumber, m.address, m.point,  m.roleType) from MEMBER m where m.id=:id")
    Optional<MemberInfoDto> findMemberById(@Param("id") Long id);

}
