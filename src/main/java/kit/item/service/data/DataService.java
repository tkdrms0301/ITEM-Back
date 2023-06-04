package kit.item.service.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kit.item.domain.it.Product;
import kit.item.dto.entity.data.*;
import kit.item.dto.entity.device.BrandDto;
import kit.item.dto.entity.device.CategoryDto;
import kit.item.dto.entity.device.ProductDto;
import kit.item.dto.request.data_server.RequestReviewDto;
import kit.item.repository.data.DataRepository;
import kit.item.repository.data.PosAndNegRepository;
import kit.item.repository.it.CategoryBrandRepository;
import kit.item.repository.it.CategoryRepository;
import kit.item.repository.it.ProductRepository;
import kit.item.util.http.HttpUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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
    private final CategoryRepository categoryRepository;
    private final CategoryBrandRepository categoryBrandRepository;

    @Value("${serverUrl}")
    private String serverUrl;
    public DataResultDto getData(Long productId) {
        log.info("DeviceManagementService.getData productId");
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
        dataResultDto.setPosAndNegDto(null);
        dataResultDto.setRelatedWords(new ArrayList<>());
        return dataResultDto;
    }

    public List<DataResultDto> getData(String word) {
        log.info("DeviceManagementService.getData word");
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

        List<String> wordList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("|");
        }
        String string = sb.toString();
        
        WordInputsDto wordInputsDto = WordInputsDto.builder()
                .input(string)
                .build();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(wordInputsDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            String res = HttpUtil.postJson(serverUrl+"/data-search", json);
            try {
                JSONArray jsonArray = new JSONArray(res);
                for (int i = 0; i < jsonArray.length(); i++) {
                    String item = jsonArray.getString(i);
                    wordList.add(item);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.info("DeviceManagementService.getDataList");
        // words는 검색어들, products는 제품 id
        List<DataResultDto> datas = new ArrayList<>();
        List<DataResultDto> dataResultDtoList = null;
        for (String word : words) {
            dataResultDtoList = getData(word);
            for (DataResultDto dataResultDto : dataResultDtoList) {
                if (!dataResultDto.check(datas)) {
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

    public String getDataCsvList(List<String> words, List<Long> productIds) {
        log.info("DeviceManagementService.getDataList");
        List<DataResultDto> dataList = getDataList(words, productIds);
        StringBuilder data = new StringBuilder();
        data.append("검색어|제품명|단어|빈도수").append("\n");
        for (DataResultDto dataResultDto : dataList) {
            for (RelatedWordDto relatedWordDto : dataResultDto.getRelatedWords()) {
                data.append(dataResultDto.getWord()).append("|")
                    .append(dataResultDto.getProductName()).append("|")
                    .append(relatedWordDto.getLabel()).append("|")
                    .append(relatedWordDto.getValue())
                    .append("\n");
            }
        }
        return data.toString();
    }

    public String getPosAndNegCsvList(List<String> words, List<Long> productIds) {
        log.info("DeviceManagementService.getPosAndNegList");
        List<DataResultDto> dataList = getDataList(words, productIds);
        StringBuilder data = new StringBuilder();
        data.append("검색어|제품명|긍정|부정").append("\n");
        for (DataResultDto dataResultDto : dataList) {
            data.append(dataResultDto.getWord()).append("|")
                .append(dataResultDto.getProductName()).append("|")
                .append(dataResultDto.getPosAndNegDto().getPositive()).append("|")
                .append(dataResultDto.getPosAndNegDto().getNegative())
                .append("\n");
        }
        return data.toString();
    }

    // category - completion 완제품(컴퓨터, 노트북, 스마트폰, 태블릿)
    public List<CategoryDto> getCategoryList() {
        log.info("DeviceManagementService.getCategoryList");
        return categoryRepository.findAllCategory();
    }

    // categoryId -> brand 완제품
    public List<BrandDto> getBrandList(Long categoryId) {
        log.info("DeviceManagementService.getBrandList");
        return categoryBrandRepository.findAllBrandByCategoryId(categoryId);
    }

    // brandId -> product 완제품
    public List<ProductDto> getProductList(Long categoryId, Long brandId) {
        log.info("DeviceManagementService.getProductList");
        return categoryBrandRepository.findAllByCategoryIdAndBrandId(categoryId, brandId);
    }
}
