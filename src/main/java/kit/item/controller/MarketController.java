package kit.item.controller;

import com.azure.core.annotation.Get;
import com.azure.core.annotation.Post;
import kit.item.dto.common.MsgDto;
import kit.item.dto.entity.device.CategoryDto;
import kit.item.dto.entity.market.CategoryInfoDto;
import kit.item.dto.entity.market.SaleProductInfoDto;
import kit.item.dto.entity.repairShop.RepairServiceReviewDto;
import kit.item.dto.request.community.RequestReportDto;
import kit.item.dto.request.market.RequestMarketReviewCreateDto;
import kit.item.dto.request.market.RequestMarketReviewDeleteDto;
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
    @GetMapping("/listByCategory")
    public List<SaleProductInfoDto> getSaleProductListByCategory(@RequestParam Long categoryId) {
        return marketService.findByCategory(categoryId);
    }

    @GetMapping("/productDetail")
    public SaleProductInfoDto getSaleProductDetail(@RequestParam Long saleProductId) {
        return marketService.findById(saleProductId);
    }


    @PostMapping("/registReview")
    public boolean registReview(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken, @RequestBody RequestMarketReviewCreateDto requestMarketReviewCreateDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));

        return marketService.createMarketReview(memberId, requestMarketReviewCreateDto);
    }

    @PostMapping("/updateReview")
    public boolean updateReview(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken, @RequestBody RequestMarketReviewUpdateDto requestMarketReviewCreateDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return marketService.updateMarketReview(memberId, requestMarketReviewCreateDto);
    }

    @PostMapping("/deleteReview")
    public boolean deleteReview(@RequestBody RequestMarketReviewDeleteDto requestMarketReviewDeleteDto) {
        return marketService.deleteMarketReview(requestMarketReviewDeleteDto.getId());
    }

    @PostMapping("/reportReview")
    public  ResponseEntity<MsgDto> reportReview(
                                @RequestBody RequestReportDto requestReportDto,
                                @RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));

        System.out.println("requestReportDto = " + requestReportDto.getReason());
        System.out.println("requestReportDto = " + requestReportDto.getReportType());

        return ResponseEntity.ok(new MsgDto(true, "",marketService.reportMarketReview(memberId, requestReportDto)));
    }

}
