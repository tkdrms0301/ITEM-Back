package kit.item.controller;

import com.azure.core.annotation.Get;
import com.azure.core.annotation.Post;
import kit.item.dto.common.MsgDto;
import kit.item.dto.entity.device.CategoryDto;
import kit.item.dto.entity.market.CategoryInfoDto;
import kit.item.dto.entity.market.SaleProductInfoDto;
import kit.item.dto.entity.repairShop.RepairServiceReviewDto;
import kit.item.dto.request.market.RequestMarketReviewCreateDto;
import kit.item.dto.request.market.RequestMarketReviewUpdateDto;
import kit.item.service.market.MarketService;
import kit.item.util.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/market")
public class MarketController {
    private final MarketService marketService;
    private final TokenProvider tokenProvider;

    @GetMapping("/category")
    public List<CategoryDto> getCategoryList() {
        return marketService.getCategoryList();
    }

}
