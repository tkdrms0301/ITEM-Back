package kit.item.repository.point;

import kit.item.domain.point.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    boolean existsByMemberId(Long memberId);

    Subscription findByMemberId(Long memberId);
}
