package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.entity.data.DataCsvDto;
import kit.item.dto.entity.data.DataResultDto;
import kit.item.dto.entity.device.BrandDto;
import kit.item.dto.entity.device.CategoryDto;
import kit.item.dto.entity.device.ProductDto;
import kit.item.dto.request.data.RequestDataDto;
import kit.item.service.data.DataService;
import kit.item.service.subscription.SubscriptionService;
import kit.item.util.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/data")
public class DataController {
    private final DataService dataService;
    private final SubscriptionService subscriptionService;
    private final TokenProvider tokenProvider;

    @PostMapping("/get")
    public ResponseEntity<MsgDto> getData(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken, @RequestBody RequestDataDto requestDataDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if (!subscriptionService.isExist(memberId)) {
            return new ResponseEntity<>(new MsgDto(false, "구독 정보가 없음", new ArrayList<>()), HttpStatus.OK);
        }
        List<String> words = requestDataDto.getWords();
        List<Long> products = requestDataDto.getProducts();
        List<DataResultDto> dataList = dataService.getDataList(words, products);
        if (dataList.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(true, "조회된 제품 데이터가 없음", new ArrayList<>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "제품 데이터 조회 성공", dataList), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<MsgDto> getCompletionCategory(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if (!subscriptionService.isExist(memberId)) {
            return new ResponseEntity<>(new MsgDto(false, "구독 정보가 없음", new ArrayList<>()), HttpStatus.OK);
        }
        List<CategoryDto> categoryDtos = dataService.getCategoryList();
        if(categoryDtos.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 완제품 카테고리가 없음", new ArrayList<CategoryDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "완제품 카테고리 조회 성공", categoryDtos), HttpStatus.OK);
    }

    @GetMapping("/brand")
    public ResponseEntity<MsgDto> getCompletionBrand(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                                     @RequestParam Long category) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if (!subscriptionService.isExist(memberId)) {
            return new ResponseEntity<>(new MsgDto(false, "구독 정보가 없음", new ArrayList<>()), HttpStatus.OK);
        }
        List<BrandDto> brandDtos = dataService.getBrandList(category);
        if(brandDtos.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 완제품 브랜드가 없음", new ArrayList<BrandDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "완제품 브랜드 조회 성공", brandDtos), HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<MsgDto> getCompletionProduct(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                                       @RequestParam Long category,
                                                       @RequestParam Long brand) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if (!subscriptionService.isExist(memberId)) {
            return new ResponseEntity<>(new MsgDto(false, "구독 정보가 없음", new ArrayList<>()), HttpStatus.OK);
        }
        List<ProductDto> productDtos = dataService.getProductList(category, brand);
        if(productDtos.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 제품이 없음", new ArrayList<ProductDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "제품 조회 성공", productDtos), HttpStatus.OK);
    }

    @PostMapping(value = "/download-related-word-data", produces = "text/csv")
    public ResponseEntity<String> getDataTest(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                              @RequestBody RequestDataDto requestDataDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if (!subscriptionService.isExist(memberId)) {
            return new ResponseEntity<>("구독 정보가 없음", HttpStatus.CREATED);
        }
        List<String> words = requestDataDto.getWords();
        List<Long> products = requestDataDto.getProducts();

        String exportFileName = "related_word_data_" + LocalDate.now() + ".csv";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/csv;charset=euc-kr");
        headers.add("Content-Disposition", "attachment; filename=" + exportFileName);

        String dataList = dataService.getDataCsvList(words, products);

        if (dataList.isEmpty())
            return new ResponseEntity<>("조회된 데이터가 없음", HttpStatus.OK);
        return new ResponseEntity<>(dataList, headers, HttpStatus.CREATED);
    }

    @ResponseBody
    @PostMapping(value = "/download-pos-and-neg-data", produces = "text/csv")
    public ResponseEntity<String> getPosAndNegTest(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                                   @RequestBody RequestDataDto requestDataDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if (!subscriptionService.isExist(memberId)) {
            return new ResponseEntity<>("구독 정보가 없음", HttpStatus.OK);
        }
        List<String> words = requestDataDto.getWords();
        List<Long> products = requestDataDto.getProducts();

        String exportFileName = "pos_and_neg_data_" + LocalDate.now() + ".csv";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/csv;charset=euc-kr");
        headers.add("Content-Disposition", "attachment; filename=" + exportFileName);

        String dataList = dataService.getPosAndNegCsvList(words, products);

        if (dataList.isEmpty())
            return new ResponseEntity<>("조회된 데이터가 없음", HttpStatus.OK);
        return new ResponseEntity<>(dataList, headers, HttpStatus.CREATED);
    }
}
