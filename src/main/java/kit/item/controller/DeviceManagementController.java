package kit.item.controller;

import kit.item.domain.it.Product;
import kit.item.dto.common.MsgDto;
import kit.item.dto.entity.device.*;
import kit.item.dto.request.device.*;
import kit.item.repository.it.CategoryBrandRepository;
import kit.item.service.device.DeviceManagementService;
import kit.item.util.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static kit.item.util.prefix.ConstPrefix.X_AUTH_TOKEN;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/device")
public class DeviceManagementController {
    private final TokenProvider tokenProvider;
    private final DeviceManagementService deviceManagementService;

    @GetMapping("/completion-category")
    public ResponseEntity<MsgDto> getCompletionCategory() {
        List<CategoryDto> categoryDtos = deviceManagementService.getCompletionCategoryList();
        if(categoryDtos.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 완제품 카테고리가 없음", new ArrayList<CategoryDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "완제품 카테고리 조회 성공", categoryDtos), HttpStatus.OK);
    }

    @GetMapping("/part-category")
    public ResponseEntity<MsgDto> getPartCategory() {
        List<CategoryDto> categoryDtos = deviceManagementService.getPartCategoryList();
        if(categoryDtos.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 부품 카테고리가 없음", new ArrayList<CategoryDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "부품 카테고리 조회 성공", categoryDtos), HttpStatus.OK);
    }

    @GetMapping("/completion-brand")
    public ResponseEntity<MsgDto> getCompletionBrand(@RequestParam Long category) {
        List<BrandDto> brandDtos = deviceManagementService.getCompletionBrandList(category);
        if(brandDtos.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 완제품 브랜드가 없음", new ArrayList<BrandDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "완제품 브랜드 조회 성공", brandDtos), HttpStatus.OK);
    }

    @GetMapping("/part-brand")
    public ResponseEntity<MsgDto> getPartBrand(@RequestParam Long category) {
        List<BrandDto> brandDtos = deviceManagementService.getPartBrandList(category);
        if(brandDtos.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 완제품 브랜드가 없음", new ArrayList<BrandDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "완제품 브랜드 조회 성공", brandDtos), HttpStatus.OK);
    }

    @GetMapping("/completion-product")
    public ResponseEntity<MsgDto> getCompletionProduct(@RequestParam Long category, @RequestParam Long brand) {
        List<ProductDto> productDtos = deviceManagementService.getCompletionProductList(category, brand);
        if(productDtos.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 제품이 없음", new ArrayList<ProductDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "제품 조회 성공", productDtos), HttpStatus.OK);
    }

    @GetMapping("/part-product")
    public ResponseEntity<MsgDto> getPartProduct(@RequestParam Long category, @RequestParam Long brand) {
        List<ProductDto> productDtos = deviceManagementService.getPartProductList(category, brand);
        if(productDtos.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 제품이 없음", new ArrayList<ProductDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "제품 조회 성공", productDtos), HttpStatus.OK);
    }

    @GetMapping("/get-device")
    public ResponseEntity<MsgDto> getDevice(@RequestHeader(value = X_AUTH_TOKEN) String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        List<MyDeviceTypeDto> myDeviceList = deviceManagementService.getMyDeviceList(memberId);
        if(myDeviceList.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 기기가 없음", new ArrayList<MyDeviceTypeDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "제품 조회 성공", myDeviceList), HttpStatus.OK);
    }

    @PostMapping("/create-device")
    public ResponseEntity<MsgDto> createDevice(@RequestHeader(value = X_AUTH_TOKEN) String accessToken, @RequestBody RequestCreateDeviceDto requestCreateDeviceDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        DeviceDto myDevice = deviceManagementService.createMyDevice(memberId, requestCreateDeviceDto);
        if(myDevice != null) {
            return new ResponseEntity<>(new MsgDto(true, "기기 등록 성공", myDevice), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "기기 등록 실패", null), HttpStatus.OK);
    }

    @PostMapping("/delete-device")
    public ResponseEntity<MsgDto> deleteDevice(@RequestHeader(value = X_AUTH_TOKEN) String accessToken, @RequestBody RequestDeleteDeviceDto requestDeleteDeviceDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if(deviceManagementService.deleteMyDevice(memberId, requestDeleteDeviceDto.getDeviceId())) {
            return new ResponseEntity<>(new MsgDto(true, "기기 삭제 성공", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "기기 삭제 실패", null), HttpStatus.OK);
    }

    @PostMapping("/create-part")
    public ResponseEntity<MsgDto> createPart(@RequestHeader(value = X_AUTH_TOKEN) String accessToken, @RequestBody RequestCreatePartDto requestCreatePartDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        DeviceDto deviceDto = deviceManagementService.createMyPart(memberId, requestCreatePartDto);
        if(deviceDto != null) {
            return new ResponseEntity<>(new MsgDto(true, "부품 등록 성공", deviceDto), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "부품 등록 실패", null), HttpStatus.OK);
    }

    @PostMapping("/delete-part")
    public ResponseEntity<MsgDto> deleteDevice(@RequestHeader(value = X_AUTH_TOKEN) String accessToken, @RequestBody RequestDeletePartDto requestDeleteDeviceDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if(deviceManagementService.deleteMyPart(memberId, requestDeleteDeviceDto.getDeviceId())) {
            return new ResponseEntity<>(new MsgDto(true, "부품 삭제 성공", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "부품 삭제 실패", null), HttpStatus.OK);
    }
}
