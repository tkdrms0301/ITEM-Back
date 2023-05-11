package kit.item.repository;

import kit.item.domain.member.Member;
import kit.item.dto.entity.member.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);

    @Query("select new kit.item.dto.entity.member.MemberDTO(m.id, m.address, m.email, m.password, m.phoneNumber, m.name, m.nickname, m.point, m.roleType) from MEMBER m")
    List<MemberDTO> findAllMemberBasicInfo();
}
