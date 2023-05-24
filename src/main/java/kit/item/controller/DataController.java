package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.entity.data.DataDto;
import kit.item.dto.entity.data.PosAndNegDto;
import kit.item.dto.entity.device.CategoryDto;
import kit.item.dto.request.data.RequestKeywordDto;
import kit.item.dto.request.data.RequestPosAndNegDto;
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

    @GetMapping("/keyword")
    public ResponseEntity<MsgDto> getKeyword(@RequestParam Long productId) {
        List<DataDto> dataList = dataService.getDataList(productId);
        if(dataList.isEmpty()) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 키워드가 없음", new ArrayList<CategoryDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "키워드 빈도수 조회 성공", dataList), HttpStatus.OK);
    }

    @GetMapping("/pos-and-neg")
    public ResponseEntity<MsgDto> getPosAndNeg(@RequestParam Long productId) {
        PosAndNegDto posAndNeg = dataService.getPosAndNeg(productId);
        if(posAndNeg == null) {
            return new ResponseEntity<>(new MsgDto(false, "조회된 긍/부정 빈도수가 없음", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "긍/부정 빈도수 조회 성공", posAndNeg), HttpStatus.OK);
    }
}
