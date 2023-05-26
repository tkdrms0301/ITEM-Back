package kit.item.controller;

import kit.item.dto.common.MsgDto;
import kit.item.dto.entity.data.DataResultDto;
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
}
