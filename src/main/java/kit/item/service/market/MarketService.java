package kit.item.service.market;

import kit.item.domain.market.MarketReview;
import kit.item.domain.market.SaleProduct;
import kit.item.domain.member.Member;
import kit.item.dto.entity.device.CategoryDto;
import kit.item.dto.entity.market.CategoryInfoDto;
import kit.item.dto.entity.market.MarketReviewDto;
import kit.item.dto.entity.market.SaleProductInfoDto;
import kit.item.dto.entity.market.SaleProductReviewInfoDto;
import kit.item.dto.entity.repairShop.RepairServiceReviewDto;
import kit.item.dto.request.market.RequestMarketReviewCreateDto;
import kit.item.dto.request.market.RequestMarketReviewUpdateDto;
import kit.item.repository.it.CategoryRepository;
import kit.item.repository.market.MarketReviewRepository;
import kit.item.repository.market.SaleProductRepository;
import kit.item.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private static final int PAGE_SIZE = 10;


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
        Long avgRating = marketReviewRepository.findBySaleProduct_Id(saleProduct.getId()).stream().mapToLong(marketReview -> marketReview.getRating()).sum();

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


}
