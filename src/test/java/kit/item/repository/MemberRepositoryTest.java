package kit.item.repository;

import kit.item.domain.member.Member;
import kit.item.repository.member.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("사용자 조회")
    void findByMemberId() {
        Optional<Member> member = memberRepository.findByEmail("tkdrms0301@naver.com");
        member.ifPresent(value -> System.out.println("member.toString() = " + value));
    }

    @Test
    @DisplayName("전체 사용자 조회")
    void findAll() {
        List<Member> members = memberRepository.findAll();
        for(Member member : members) {
            System.out.println("memberDTO.get().getEmail() = " + member.toString());
        }
    }
}
