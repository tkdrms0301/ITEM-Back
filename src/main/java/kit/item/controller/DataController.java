package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.entity.data.DataResultDto;
import kit.item.dto.entity.device.BrandDto;
import kit.item.dto.entity.device.CategoryDto;
import kit.item.dto.entity.device.ProductDto;
import kit.item.dto.request.data.RequestDataDto;
import kit.item.dto.response.data.ResposneDataDto;
import kit.item.service.data.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/data")
public class DataController {
    private final DataService dataService;

    @PostMapping("/get")
    public ResponseEntity<MsgDto> getData(@RequestBody RequestDataDto requestDataDto) {
        List<String> words = requestDataDto.getWords();
        List<Long> products = requestDataDto.getProducts();
        List<DataResultDto> dataList = dataService.getDataList(words, products);
        if (dataList.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(true, "조회된 제품 데이터가 없음", new ArrayList<>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "제품 데이터 조회 성공", dataList), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<MsgDto> getCompletionCategory() {
        List<CategoryDto> categoryDtos = dataService.getCategoryList();
        if(categoryDtos.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 완제품 카테고리가 없음", new ArrayList<CategoryDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "완제품 카테고리 조회 성공", categoryDtos), HttpStatus.OK);
    }

    @GetMapping("/brand")
    public ResponseEntity<MsgDto> getCompletionBrand(@RequestParam Long category) {
        List<BrandDto> brandDtos = dataService.getBrandList(category);
        if(brandDtos.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 완제품 브랜드가 없음", new ArrayList<BrandDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "완제품 브랜드 조회 성공", brandDtos), HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<MsgDto> getCompletionProduct(@RequestParam Long category, @RequestParam Long brand) {
        List<ProductDto> productDtos = dataService.getProductList(category, brand);
        if(productDtos.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 제품이 없음", new ArrayList<ProductDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "제품 조회 성공", productDtos), HttpStatus.OK);
    }
}
