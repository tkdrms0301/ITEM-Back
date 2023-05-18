package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.request.device.RequestCreateDeviceDto;
import kit.item.dto.request.device.RequestDeleteDeviceDto;
import kit.item.dto.request.device.RequestUpdateDeviceDto;
import kit.item.service.device.DeviceManagementService;
import kit.item.util.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static kit.item.util.prefix.ConstPrefix.X_AUTH_TOKEN;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/device")
public class DeviceManagementController {
    private final TokenProvider tokenProvider;
    private final DeviceManagementService deviceManagementService;

    @GetMapping("/category")
    public ResponseEntity<MsgDto> getCategory() {
        return new ResponseEntity<>(new MsgDto(true, "카테고리 조회 성공", deviceManagementService.getCategoryList()), HttpStatus.OK);
    }

    @GetMapping("/brand")
    public ResponseEntity<MsgDto> getBrand(@RequestParam Long category) {
        return new ResponseEntity<>(new MsgDto(true, "브랜드 조회 성공", deviceManagementService.getBrandList(category)), HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<MsgDto> getProduct(@RequestParam Long category, @RequestParam Long brand) {
        return new ResponseEntity<>(new MsgDto(true, "제품 조회 성공", deviceManagementService.getProductList(category, brand)), HttpStatus.OK);
    }

    @GetMapping("/get-device")
    public ResponseEntity<MsgDto> getDevice(@RequestHeader(value = X_AUTH_TOKEN) String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return new ResponseEntity<>(new MsgDto(true, "제품 조회 성공", deviceManagementService.getMyDeviceList(memberId)), HttpStatus.OK);
    }

    @PostMapping("/create-device")
    public ResponseEntity<MsgDto> createDevice(@RequestHeader(value = X_AUTH_TOKEN) String accessToken, @RequestBody RequestCreateDeviceDto requestCreateDeviceDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if(deviceManagementService.createMyDevice(memberId, requestCreateDeviceDto)) {
            return new ResponseEntity<>(new MsgDto(true, "기기 등록 성공", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "기기 등록 실패", null), HttpStatus.OK);
    }

    @PostMapping("/update-device")
    public ResponseEntity<MsgDto> updateDevice(@RequestHeader(value = X_AUTH_TOKEN) String accessToken, @RequestBody RequestUpdateDeviceDto requestUpdateDeviceDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if(deviceManagementService.updateMyDevice(memberId, requestUpdateDeviceDto)) {
            return new ResponseEntity<>(new MsgDto(true, "기기 수정 성공", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "기기 수정 실패", null), HttpStatus.OK);
    }

    @PostMapping("/delete-device")
    public ResponseEntity<MsgDto> deleteDevice(@RequestHeader(value = X_AUTH_TOKEN) String accessToken, @RequestBody RequestDeleteDeviceDto requestDeleteDeviceDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        if(deviceManagementService.deleteMyDevice(memberId, requestDeleteDeviceDto.getDeviceId())) {
            return new ResponseEntity<>(new MsgDto(true, "기기 삭제 성공", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "기기 삭제 실패", null), HttpStatus.OK);
    }
}
