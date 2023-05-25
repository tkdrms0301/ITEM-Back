package kit.item.service.data;

import kit.item.domain.data.Data;
import kit.item.domain.it.Product;
import kit.item.dto.entity.data.*;
import kit.item.dto.response.data.ResposneDataDto;
import kit.item.repository.data.DataRepository;
import kit.item.repository.data.PosAndNegRepository;
import kit.item.repository.it.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kit.item.util.prefix.ConstData.MAXIMUM_DATA_RESULT;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DataService {
    private final PosAndNegRepository posAndNegRepository;
    private final DataRepository dataRepository;
    private final ProductRepository productRepository;

    public DataResultDto getData(String word) {
        DataResultDto dataResultDto = new DataResultDto();
        dataResultDto.setWord(word);

        Pageable pageRequest = PageRequest.of(0, MAXIMUM_DATA_RESULT);
        Page<Data> dataListByVocab = dataRepository.findAllByVocab(word, pageRequest);
//        Page<DataDto> dataListByVocab = dataRepository.getDataListByVocab(word, pageRequest);
//        if (dataListByVocab.isEmpty()) {
//            dataResultDto.setRelatedWords(new ArrayList<>());
//        }else {
//            List<RelatedWordDto> relatedWords = new ArrayList<>();
//            for (DataDto dto : dataListByVocab) {
//                relatedWords.add(new RelatedWordDto(dto.getVocab(), dto.getCount()));
//            }
//            dataResultDto.setRelatedWords(relatedWords);
//        }

        Optional<Product> product = productRepository.findByName(word);
        if (product.isPresent()) {
            PosAndNegDto posAndNegDto = posAndNegRepository.getPosAndNegByProductId(product.get().getId());
            dataResultDto.setPosAndNegDto(posAndNegDto);
        } else {
            dataResultDto.setPosAndNegDto(new PosAndNegDto());
        }
        return dataResultDto;
    }

    public DataResultDto getData(Long productId) {
        DataResultDto dataResultDto = new DataResultDto();
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            PosAndNegDto posAndNegDto = posAndNegRepository.getPosAndNegByProductId(product.get().getId());
            dataResultDto.setPosAndNegDto(posAndNegDto);
            dataResultDto.setWord(product.get().getName());
            List<DataDto> dataListByProductId = dataRepository.getDataListByProductId(productId);
            if (dataListByProductId.isEmpty()) {
                dataResultDto.setRelatedWords(new ArrayList<>());
            }else {
                List<RelatedWordDto> relatedWords = new ArrayList<>();
                for (DataDto dto : dataListByProductId) {
                    relatedWords.add(new RelatedWordDto(dto.getVocab(), dto.getCount()));
                }
                dataResultDto.setRelatedWords(relatedWords);
            }
        } else {
            dataResultDto.setPosAndNegDto(new PosAndNegDto());
            dataResultDto.setWord(null);
            dataResultDto.setRelatedWords(new ArrayList<>());
        }
        return dataResultDto;
    }

    public ResposneDataDto getDataList(List<String> words, List<Long> productIds) {
        // words는 검색어들, products는 제품 id
        List<DataResultDto> datas = new ArrayList<>();
        for (String word : words) {
            DataResultDto dataResultDto = getData(word);
            datas.add(dataResultDto);
        }

        for (Long productId : productIds) {
            DataResultDto dataResultDto = getData(productId);
            datas.add(dataResultDto);
        }

        return ResposneDataDto.builder().datas(datas).build();
    }
}
