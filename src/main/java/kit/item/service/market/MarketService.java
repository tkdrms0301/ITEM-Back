package kit.item.service.market;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kit.item.domain.market.MarketReview;
import kit.item.domain.market.MarketReviewReport;
import kit.item.domain.market.SaleProduct;
import kit.item.domain.member.Member;
import kit.item.domain.post.Post;
import kit.item.domain.post.PostReport;
import kit.item.dto.entity.device.CategoryDto;
import kit.item.dto.entity.market.*;
import kit.item.dto.entity.repairShop.RepairServiceReviewDto;
import kit.item.dto.request.community.RequestReportDto;
import kit.item.dto.request.data_server.RequestPostDto;
import kit.item.dto.request.data_server.RequestReviewDto;
import kit.item.dto.request.market.RequestMarketReviewCreateDto;
import kit.item.dto.request.market.RequestMarketReviewUpdateDto;
import kit.item.repository.it.CategoryRepository;
import kit.item.repository.market.MarketReviewReportRepository;
import kit.item.repository.market.MarketReviewRepository;
import kit.item.repository.market.SaleProductRepository;
import kit.item.repository.member.MemberRepository;
import kit.item.util.http.HttpUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MarketService {
    private final SaleProductRepository saleProductRepository;
    private final MarketReviewRepository marketReviewRepository;
    private final CategoryRepository categoryRepository;
    private final MemberRepository memberRepository;
    private final MarketReviewReportRepository marketReviewReportRepository;

    private final int DELETE_REVIEW_COUNT = 10;

    @Value("${serverUrl}")
    private String serverUrl;


    //카테고리 id로 찾기
    public List<SaleProductInfoDto> findByCategory(Long categoryId) {
        List<SaleProductInfoDto> saleProductInfoDtoList = new ArrayList<>();
        List<SaleProduct> saleProducts = saleProductRepository.findByProduct_CategoryBrand_Category_Id(categoryId);
        saleProducts.stream().forEach(
                saleProduct -> {
                    List<String> imgDetailUrlList = new ArrayList<>();
                    saleProduct.getImageDetails().stream().forEach(
                            imageDetail -> {
                                imgDetailUrlList.add(imageDetail.getUrl());
                            }
                    );
                    //리뷰 정보
                    List<SaleProductReviewInfoDto> reviewList = new ArrayList<>();
                    marketReviewRepository.findBySaleProduct_Id(saleProduct.getId()).stream().forEach(
                            marketReview -> {
                                SaleProductReviewInfoDto saleProductReviewInfoDto = SaleProductReviewInfoDto.builder()
                                        .id(marketReview.getId())
                                        .ownerId(marketReview.getMember().getId())
                                        .ownerName(marketReview.getMember().getNickname())
                                        .date(marketReview.getDate())
                                        .comment(marketReview.getComment())
                                        .rating(marketReview.getRating())
                                        .build();
                                reviewList.add(saleProductReviewInfoDto);
                            }
                    );

                    //평균 리뷰 점수
                    Long avgRating = marketReviewRepository.findBySaleProduct_Id(saleProduct.getId()).stream().mapToLong(marketReview -> marketReview.getRating()).sum();

                    //상품 리스트애 추가
                    SaleProductInfoDto saleProductInfoDto = SaleProductInfoDto.builder()
                            .id(saleProduct.getId())
                            .name(saleProduct.getName())
                            .thumbnailUrl(saleProduct.getThumbnailUrl())
                            .price(saleProduct.getCost())
                            .deliveryCompany(saleProduct.getDeliveryCompany())
                            .deliveryCost(saleProduct.getDeliveryCost())
                            .comment(saleProduct.getComment())
                            .imageUrls(imgDetailUrlList)
                            .rating(avgRating)
                            .reviewList(reviewList)
                            .build();

                    saleProductInfoDtoList.add(saleProductInfoDto);
                }
        );
        return saleProductInfoDtoList;
    }

    //상품 id로 찾기
    public SaleProductInfoDto findById(Long saleProductId) {
        SaleProduct saleProduct = saleProductRepository.findById(saleProductId).get();
        List<String> imgDetailUrlList = new ArrayList<>();
        saleProduct.getImageDetails().stream().forEach(
                imageDetail -> {
                    imgDetailUrlList.add(imageDetail.getUrl());
                }
        );
        //리뷰 정보
        List<SaleProductReviewInfoDto> reviewList = new ArrayList<>();
        marketReviewRepository.findBySaleProduct_Id(saleProduct.getId()).stream().forEach(
                marketReview -> {
                    SaleProductReviewInfoDto saleProductReviewInfoDto = SaleProductReviewInfoDto.builder()
                            .id(marketReview.getId())
                            .ownerId(marketReview.getMember().getId())
                            .ownerName(marketReview.getMember().getNickname())
                            .date(marketReview.getDate())
                            .comment(marketReview.getComment())
                            .rating(marketReview.getRating())
                            .build();
                    reviewList.add(saleProductReviewInfoDto);
                }
        );

        //평균 리뷰 점수
        List<MarketReview> reviews = marketReviewRepository.findBySaleProduct_Id(saleProduct.getId());
        double avgRating = Math.round(reviews.stream()
                .mapToLong(MarketReview::getRating)
                .average()
                .orElse(0) * 10) / 10.0;

        // 평균 리뷰 점수를 출력합니다.
        //상품 리스트에 추가
        SaleProductInfoDto saleProductInfoDto = SaleProductInfoDto.builder()
                .id(saleProduct.getId())
                .name(saleProduct.getName())
                .thumbnailUrl(saleProduct.getThumbnailUrl())
                .price(saleProduct.getCost())
                .deliveryCompany(saleProduct.getDeliveryCompany())
                .deliveryCost(saleProduct.getDeliveryCost())
                .comment(saleProduct.getComment())
                .imageUrls(imgDetailUrlList)
                .rating(avgRating)
                .reviewList(reviewList)
                .build();

        return saleProductInfoDto;
    }

    public List<CategoryDto> getCategoryList() {
        List<CategoryDto> categoryInfoDtoList = categoryRepository.findAllCategory();
        return categoryInfoDtoList;
    }

    public boolean createMarketReview(Long memberId, RequestMarketReviewCreateDto requestMarketReviewCreateDto) {
        MarketReview exsistMarketReview = marketReviewRepository.findByMember_IdAndSaleProduct_Id(memberId, requestMarketReviewCreateDto.getSaleProductId());

        if (exsistMarketReview != null) {
            return false;
        }



        Member member = memberRepository.findById(memberId).get();
        SaleProduct saleProduct = saleProductRepository.findById(requestMarketReviewCreateDto.getSaleProductId()).get();


        ObjectMapper objectMapper = new ObjectMapper();
        RequestReviewDto requestReviewDto = RequestReviewDto.builder()
                .productId(saleProduct.getProduct().getId())
                .review(requestMarketReviewCreateDto.getComment())
                .build();
        ObjectMapper objectMapperKeyword = new ObjectMapper();
        RequestPostDto requestPostDto = RequestPostDto.builder()
                .productId(saleProduct.getProduct().getId())
                .content(requestMarketReviewCreateDto.getComment())
                .build();
        String json = null;
        String jsonReview = null;
        try {
            json = objectMapper.writeValueAsString(requestReviewDto);
            jsonReview = objectMapperKeyword.writeValueAsString(requestPostDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            String res = HttpUtil.postJson(serverUrl + "/sentiment-classification", json);
            String res2 = HttpUtil.postJson(serverUrl + "/keyword-extraction", jsonReview);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MarketReview marketReview = MarketReview.builder()
                .member(member)
                .comment(requestMarketReviewCreateDto.getComment())
                .date(LocalDateTime.now())
                .rating(requestMarketReviewCreateDto.getRating())
                .saleProduct(saleProduct)
                .build();
        marketReviewRepository.save(marketReview);
        return true;
    }

    public boolean updateMarketReview(Long memberId, RequestMarketReviewUpdateDto requestMarketReviewUpdateDto) {
        MarketReview beforeMarketReview = marketReviewRepository.findByMember_IdAndSaleProduct_Id(memberId, requestMarketReviewUpdateDto.getSaleProductId());

        beforeMarketReview.setComment(requestMarketReviewUpdateDto.getComment());
        beforeMarketReview.setDate(LocalDateTime.now());
        beforeMarketReview.setRating(requestMarketReviewUpdateDto.getRating());

        marketReviewRepository.save(beforeMarketReview);

        return true;
    }

    public boolean deleteMarketReview(Long memberId, Long id) {
        Optional<MarketReview> marketReview = marketReviewRepository.findByIdAndMember_Id(id, memberId);
        if (marketReview.isPresent()){
            marketReviewRepository.delete(marketReview.get());
            return true;
        }
        return false;
    }

    public boolean reportMarketReview(Long memberId, RequestReportDto requestReportDto) {
        Optional<MarketReview> marketReview = marketReviewRepository.findById(requestReportDto.getId());
        if (marketReview.isPresent()){

            MarketReviewReport byMemberIdAndMarketReviewId = marketReviewReportRepository.findByMember_IdAndMarketReview_Id(memberId, requestReportDto.getId());
            if (byMemberIdAndMarketReviewId != null){
                return false;
            }

            MarketReviewReport marketReviewReport = MarketReviewReport.builder()
                    .reason(requestReportDto.getReason())
                    .reportType(requestReportDto.getReportType())
                    .member(Member.builder()
                            .id(memberId)
                            .build())
                    .marketReview(marketReview.get())
                    .build();
            marketReviewReportRepository.save(marketReviewReport);

            ReportCountDto reportCountDto = marketReviewReportRepository.countBymarketReviewId(requestReportDto.getId());

            if (reportCountDto.getCount() >= DELETE_REVIEW_COUNT){
                marketReviewReportRepository.deleteByMarketReview(marketReview.get());
                marketReviewRepository.delete(marketReview.get());
            }

            return true;
        }
        return false;
    }

    public List<SaleProductInfoDto> searchProducts(String keyword) {
        List<SaleProduct> saleProductList = saleProductRepository.findByNameContaining(keyword);
        List<SaleProductInfoDto> saleProductInfoDtoList = new ArrayList<>();
        saleProductList.stream().forEach(
                saleProduct -> {
                    List<String> imgDetailUrlList = new ArrayList<>();
                    saleProduct.getImageDetails().stream().forEach(
                            imageDetail -> {
                                imgDetailUrlList.add(imageDetail.getUrl());
                            }
                    );
                    //리뷰 정보
                    List<SaleProductReviewInfoDto> reviewList = new ArrayList<>();
                    marketReviewRepository.findBySaleProduct_Id(saleProduct.getId()).stream().forEach(
                            marketReview -> {
                                SaleProductReviewInfoDto saleProductReviewInfoDto = SaleProductReviewInfoDto.builder()
                                        .id(marketReview.getId())
                                        .ownerId(marketReview.getMember().getId())
                                        .ownerName(marketReview.getMember().getNickname())
                                        .date(marketReview.getDate())
                                        .comment(marketReview.getComment())
                                        .rating(marketReview.getRating())
                                        .build();
                                reviewList.add(0 , saleProductReviewInfoDto);
                            }
                    );

                    //평균 리뷰 점수
                    Long avgRating = marketReviewRepository.findBySaleProduct_Id(saleProduct.getId()).stream().mapToLong(marketReview -> marketReview.getRating()).sum();

                    //상품 리스트애 추가
                    SaleProductInfoDto saleProductInfoDto = SaleProductInfoDto.builder()
                            .id(saleProduct.getId())
                            .name(saleProduct.getName())
                            .thumbnailUrl(saleProduct.getThumbnailUrl())
                            .price(saleProduct.getCost())
                            .deliveryCompany(saleProduct.getDeliveryCompany())
                            .deliveryCost(saleProduct.getDeliveryCost())
                            .comment(saleProduct.getComment())
                            .imageUrls(imgDetailUrlList)
                            .rating(avgRating)
                            .reviewList(reviewList)
                            .build();

                    saleProductInfoDtoList.add(saleProductInfoDto);
                }
        );
        return saleProductInfoDtoList;

    }
}