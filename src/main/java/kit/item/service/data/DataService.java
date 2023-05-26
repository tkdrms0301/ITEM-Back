package kit.item.service.data;

import kit.item.domain.it.Product;
import kit.item.dto.entity.data.*;
import kit.item.repository.data.DataRepository;
import kit.item.repository.data.PosAndNegRepository;
import kit.item.repository.it.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kit.item.util.prefix.ConstData.MAXIMUM_DATA_RESULT;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DataService {
    private final PosAndNegRepository posAndNegRepository;
    private final DataRepository dataRepository;
    private final ProductRepository productRepository;

    public DataResultDto getData(Long productId) {
        DataResultDto dataResultDto = new DataResultDto();

        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            dataResultDto.setProductId(product.get().getId());
            dataResultDto.setWord(product.get().getName());
            dataResultDto.setProductName(product.get().getName());
            PosAndNegDto posAndNegDto = posAndNegRepository.getPosAndNegByProductId(product.get().getId());
            dataResultDto.setPosAndNegDto(posAndNegDto == null ? new PosAndNegDto() : posAndNegDto);

            Pageable pageable = PageRequest.of(0, MAXIMUM_DATA_RESULT, Sort.by("count").descending());
            List<DataDto> dataListByProductId = dataRepository.getDataListByProductId(productId, pageable).getContent();
            if (dataListByProductId.isEmpty()) {
                dataResultDto.setRelatedWords(new ArrayList<>());
            }else {
                List<RelatedWordDto> relatedWords = new ArrayList<>();
                for (DataDto dto : dataListByProductId) {
                    relatedWords.add(new RelatedWordDto(dto.getVocab(), dto.getCount()));
                }
                dataResultDto.setRelatedWords(relatedWords);
            }
            return dataResultDto;
        }
        dataResultDto.setWord(null);
        dataResultDto.setProductName(null);
        dataResultDto.setPosAndNegDto(new PosAndNegDto());
        dataResultDto.setRelatedWords(new ArrayList<>());
        return dataResultDto;
    }

    public List<DataResultDto> getData(String word) {
        List<DataResultDto> dataResultDtoList = new ArrayList<>();

        // word로 검색한 데이터를 count로 내림차순 정렬하여 가져온다.
        Pageable pageable = PageRequest.of(0, MAXIMUM_DATA_RESULT, Sort.by("count").descending());
        List<DataDto> dataListByWord = dataRepository.getDataListByWord(word, pageable).getContent();

        // word로 검색한 데이터가 없으면 빈 리스트를 반환한다.
        for (DataDto dataDto : dataListByWord) {
            Optional<Product> product = productRepository.findById(dataDto.getProductId());
            if (product.isPresent()) {
                DataResultDto dataResultDto = new DataResultDto();
                dataResultDto.setProductId(product.get().getId());
                dataResultDto.setWord(word);
                dataResultDto.setProductName(product.get().getName());

                PosAndNegDto posAndNegDto = posAndNegRepository.getPosAndNegByProductId(product.get().getId());
                dataResultDto.setPosAndNegDto(posAndNegDto == null ? new PosAndNegDto() : posAndNegDto);

                List<DataDto> dataDtoList = dataRepository.getDataListByProductId(product.get().getId(), pageable).getContent();
                List<RelatedWordDto> relatedWords = new ArrayList<>();
                for (DataDto dto : dataDtoList) {
                    relatedWords.add(new RelatedWordDto(dto.getVocab(), dto.getCount()));
                }
                dataResultDto.setRelatedWords(relatedWords);
                dataResultDtoList.add(dataResultDto);
            }
        }
        return dataResultDtoList;
    }

    public List<DataResultDto> getDataList(List<String> words, List<Long> productIds) {
        // words는 검색어들, products는 제품 id
        List<DataResultDto> datas = new ArrayList<>();
        List<DataResultDto> dataResultDtoList = null;
        for (String word : words) {
            dataResultDtoList = getData(word);
            for (DataResultDto dataResultDto : dataResultDtoList) {
                if (productIds.contains(dataResultDto.getProductId())) {
                    datas.add(dataResultDto);
                }
            }
        }
        for (Long productId : productIds) {
            DataResultDto dataResultDto = getData(productId);
            if (dataResultDto.getProductName() != null && !dataResultDto.check(datas)) {
                datas.add(dataResultDto);
            }
        }
        return datas;
    }
}
