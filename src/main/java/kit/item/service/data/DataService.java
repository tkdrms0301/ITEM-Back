package kit.item.service.data;

import kit.item.dto.entity.data.DataDto;
import kit.item.dto.entity.data.PosAndNegDto;
import kit.item.repository.data.DataRepository;
import kit.item.repository.data.PosAndNegRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DataService {
    private final PosAndNegRepository posAndNegRepository;
    private final DataRepository dataRepository;

    public List<DataDto> getDataList(Long productId) {
        return dataRepository.getDataListByProductId(productId);
    }

    public PosAndNegDto getPosAndNeg(Long productId) {
        return posAndNegRepository.getPosAndNegByProductId(productId);
    }
}
