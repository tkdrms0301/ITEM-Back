package kit.item.service.market;

import kit.item.repository.market.MarketReviewRepository;
import kit.item.repository.market.SaleProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MarketReviewService {
    private final SaleProductRepository saleProductRepository;
    private final MarketReviewRepository marketReviewRepository;


}
