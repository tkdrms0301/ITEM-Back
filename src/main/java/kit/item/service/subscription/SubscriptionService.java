package kit.item.service.subscription;

import kit.item.repository.point.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public boolean isExist(Long memberId){
        return subscriptionRepository.existsByMemberId(memberId);
    }
}
