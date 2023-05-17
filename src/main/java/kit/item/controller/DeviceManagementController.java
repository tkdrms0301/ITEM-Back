package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.service.device.DeviceManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/device")
public class DeviceManagementController {
    private final DeviceManagementService deviceManagementService;

    @GetMapping("/category")
    public ResponseEntity<MsgDto> getCategory() {
        return new ResponseEntity<>(new MsgDto(true, "카테고리 조회 성공", deviceManagementService.getCategoryList()), HttpStatus.OK);
    }
}
