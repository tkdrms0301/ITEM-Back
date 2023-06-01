package kit.item.controller;

import com.azure.core.annotation.Get;
import com.azure.core.annotation.Post;
import kit.item.domain.member.Member;
import kit.item.domain.repair.RepairServiceReview;
import kit.item.dto.common.MsgDto;
import kit.item.dto.entity.device.CategoryDto;
import kit.item.dto.entity.repairShop.EnableTimesDto;
import kit.item.dto.entity.repairShop.RepairServiceReviewDto;
import kit.item.dto.entity.repairShop.RepairShopIdDto;
import kit.item.dto.entity.repairShop.ReservationServiceDto;
import kit.item.dto.request.repair.*;
import kit.item.dto.response.repairShop.*;
import kit.item.exception.DuplicateHashValueException;
import kit.item.service.repairShop.RepairResultService;
import kit.item.service.repairShop.RepairShopService;
import kit.item.service.repairShop.ReviewService;
import kit.item.util.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/repair")
public class RepairShopController {
    private final RepairShopService repairShopService;
    private final RepairResultService repairResultService;
    private final ReviewService reviewService;
    private final TokenProvider tokenProvider;

    @GetMapping("/privateShops")
    public List<ResponsePrivateRepairShopDto> findAllPrivateRepairShops(@RequestHeader HttpHeaders headers) {
        return repairShopService.findAllPrivateRepairShops();
    }

    @GetMapping("/publicShops")
    public List<ResponsePublicRepairShopDto> findAllPublicRepairShops() {
        return repairShopService.findAllPublicRepairShops();
    }

    @GetMapping("/serviceList")
    public List<ResponseServiceDto> getServiceList(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return repairShopService.getServiceListByShopID(memberId);
    }

    @PostMapping("/serviceList")
    public boolean createServiceList(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken, @RequestBody RequestServiceCreateInfo requestServiceCreateInfo) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return repairShopService.createServiceList(memberId, requestServiceCreateInfo);
    }

    @DeleteMapping("/serviceList")
    public ResponseEntity getServiceList(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken, Long serviceId) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));

        boolean result = repairShopService.deleteServiceByServiceId(memberId, serviceId);
        if(result){
            return new ResponseEntity<Boolean>(result, HttpStatus.OK);
        }else
            return new ResponseEntity<Boolean>(result, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/serviceList/info")
    public ResponseServiceDto getServiceInfo(Long serviceId) {
        return repairShopService.getServiceInfo(serviceId);
    }

    @PutMapping("/serviceList/info")
    public ResponseEntity updateServiceInfo(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken, @RequestBody RequestServiceUpdateInfo requestServiceUpdateInfo) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));

        boolean result = repairShopService.updateServiceByServiceId(memberId, requestServiceUpdateInfo);
        if(result){
            return new ResponseEntity<Boolean>(result, HttpStatus.OK);
        }else
            return new ResponseEntity<Boolean>(result, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/reservation/init")
    public ResponseReservationInitDto initReservation(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken, @RequestBody RepairShopIdDto repairShopId) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return repairShopService.reservationInit(memberId, repairShopId.getRepairShopId());
    }

    @GetMapping("/reservation/getEnableTime")
    public EnableTimesDto getEnableTime(@RequestParam Long repairShopId, @RequestParam String date) {
        return repairShopService.getEnableReservationTime(repairShopId, date);
    }

    @PostMapping("/reservation/add")
    public void registReservation(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                  @RequestParam(value = "productName", required = false, defaultValue = "") String productName,
                                  @RequestParam(value = "prodImg", required = false, defaultValue = "") String prodImg,
                                  @RequestParam(value = "requestComment", required = false, defaultValue = "") String requestComment,
                                  @RequestParam(value = "serviceName", required = false) List<String> serviceNames,
                                  @RequestParam(value = "price", required = false) List<Long> prices,
                                  @RequestParam(value = "rvRequestImgs", required = false) List<MultipartFile> rvRequestImgs,
                                  @RequestParam(value = "date", required = false) LocalDate date,
                                  @RequestParam(value = "time", required = false) String time,
                                  @RequestParam(value = "repairShopId", required = false) Long repairShopId) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));

        List<ReservationServiceDto> services = new ArrayList<>();
        if (serviceNames != null && prices != null && serviceNames.size() == prices.size()) {
            for (int i = 0; i < serviceNames.size(); i++) {
                services.add(
                        ReservationServiceDto
                                .builder()
                                .serviceName(serviceNames.get(i))
                                .price(prices.get(i))
                                .build());
            }
        }

        RequestReservationDto requestReservationDto = RequestReservationDto.builder()
                .productName(productName)
                .prodImg(prodImg)
                .comment(requestComment)
                .services(services)
                .rvRequestImgs(rvRequestImgs)
                .date(date)
                .time(time)
                .repairShopId(repairShopId)
                .build();
        repairShopService.createReservation(memberId, requestReservationDto);
    }

    @GetMapping("/reservation/history")
    public List<ResponseReservaionHistoryDto> getReservationHistory(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return repairShopService.findReservationHistory(memberId);
    }

    @GetMapping("/reservation/history/detail")
    public ResponseReservaionHistoryDto getReservationDetail(@RequestParam Long reservationId) {
        return repairShopService.findReservationHistoryById(reservationId);
    }

    @PostMapping("/reservation/update")
    public void updateReservation(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                  @RequestParam(value = "productName", required = false, defaultValue = "") String productName,
                                  @RequestParam(value = "prodImg", required = false, defaultValue = "") String prodImg,
                                  @RequestParam(value = "requestComment", required = false, defaultValue = "") String requestComment,
                                  @RequestParam(value = "serviceName", required = false) List<String> serviceNames,
                                  @RequestParam(value = "price", required = false) List<Long> prices,
                                  @RequestParam(value = "rvRequestImgs", required = false) List<MultipartFile> rvRequestImgs,
                                  @RequestParam(value = "date", required = false) LocalDate date,
                                  @RequestParam(value = "time", required = false) String time,
                                  @RequestParam(value = "repairShopId", required = false) Long repairShopId,
                                  @RequestParam(value = "reservationId", required = false) Long reservationId) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));

        List<ReservationServiceDto> services = new ArrayList<>();
        if (serviceNames != null && prices != null && serviceNames.size() == prices.size()) {
            for (int i = 0; i < serviceNames.size(); i++) {
                services.add(
                        ReservationServiceDto
                                .builder()
                                .serviceName(serviceNames.get(i))
                                .price(prices.get(i))
                                .build());
            }
        }

        RequestReservationUpdateDto reservationUpdateDto = RequestReservationUpdateDto.builder()
                .id(reservationId)
                .productName(productName)
                .prodImg(prodImg)
                .comment(requestComment)
                .services(services)
                .rvRequestImgs(rvRequestImgs)
                .date(date)
                .time(time)
                .repairShopId(repairShopId)
                .build();


        repairShopService.updateReservation(memberId, reservationUpdateDto);
    }

    @GetMapping("/reservation/history/mechanic")
    public List<ResponseReservaionHistoryDto> getReservationHistoryMechanic(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return repairShopService.findReservationHistoryMechanic(memberId);
    }

    @PostMapping("/reservation/accept")
    public boolean acceptReservation(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                     @RequestBody RequestReservationStateUpdateDto requestReservationStateUpdateDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return repairShopService.acceptReservation(requestReservationStateUpdateDto.getReservationId(), memberId);
    }

    @PostMapping("/reservation/reject")
    public boolean rejectReservation(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                     @RequestBody RequestReservationStateUpdateDto requestReservationStateUpdateDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return repairShopService.rejectReservation(requestReservationStateUpdateDto.getReservationId(), memberId);
    }
    @PostMapping("/reservation/cancel")
    public boolean cancelReservation(@RequestBody RequestReservationStateUpdateDto requestReservationStateUpdateDto) {
        return repairShopService.cancelReservation(requestReservationStateUpdateDto.getReservationId());
    }


    //견적 초기
    @GetMapping("/estimate/init")
    public ResponseEstimateInitDto initEstimate(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return repairShopService.estimateInit(memberId);
    }


    //견적 신청
    @PostMapping("/estimate/regist")
    public boolean registEstimate(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                  @RequestParam(value = "productId", required = false) Long productId,
                                  @RequestParam(value = "requestImg", required = false) MultipartFile requestImg,
                                  @RequestParam(value = "comment", required = false) String comment,
                                  @RequestParam(value = "repairShopId", required = false) Long repairShopId) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));

        RequestEstimateDto requestEstimateDto = RequestEstimateDto.builder()
                .productId(productId)
                .requestImg(requestImg)
                .comment(comment)
                .repairShopId(repairShopId)
                .build();

        return repairShopService.registEstimate(memberId, requestEstimateDto);
    }

    //견적 리스트
    @GetMapping("/estimate/history")
    public List<ResponseEstimateHistoryDto> getEstimateHistory(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return repairShopService.findEstimateHistory(memberId);
    }

    @GetMapping("/estimate/history/detail")
    public ResponseEstimateHistoryDto getEstimateHistoryDetail(@RequestParam Long estimateId) {
        return repairShopService.findEstimateHistoryDetail(estimateId);
    }

    @GetMapping("/estimate/history/mechanic")
    public List<ResponseEstimateHistoryDto> getEstimateHistoryMechanic(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken) {
        Long repairShopId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        return repairShopService.findEstimateHistoryMechanic(repairShopId);
    }

    @PostMapping("/estimate/responseRegist")
    public boolean responseEstimate(@RequestBody RequestEstimateResponseDto requestEstimateResponseDto) {

        return repairShopService.responseEstimate(requestEstimateResponseDto);
    }

    @GetMapping("/report/info")
    public ResponseEntity<MsgDto> getRepairResultReportInfo(@RequestParam Long reservationId) {
        ResponseReservationInfoDto responseReservationInfoDto = repairResultService.findReservationInfo(reservationId);
        if(responseReservationInfoDto == null) {
            return new ResponseEntity<>(new MsgDto(false, "예약 정보 없음", new ArrayList<CategoryDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "예약 정보 조회", responseReservationInfoDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/report/create", method=RequestMethod.POST, consumes="multipart/form-data")
    public ResponseEntity<MsgDto> createRepairResultReport(RequestRepairResultCreateDto requestRepairResultCreateDto) {
        try {
            boolean result = repairResultService.createRepairResult(requestRepairResultCreateDto);
            if(result) {
                return new ResponseEntity<>(new MsgDto(true, "보고서 생성 성공", result), HttpStatus.OK);
            }
            return new ResponseEntity<>(new MsgDto(false, "보고서 생성 실패", result), HttpStatus.OK);
        } catch (DuplicateHashValueException e) {
            return new ResponseEntity<>(new MsgDto(false, "중복된 사진 게재", false), HttpStatus.OK);
        }
    }

    @GetMapping("/report")
    public ResponseEntity<MsgDto> getRepairResultReport(@RequestParam Long reservationId) {
        ResponseRepairDto responseRepairDto = repairResultService.getRepairResult(reservationId);
        if(responseRepairDto == null) {
            return new ResponseEntity<>(new MsgDto(false, "보고서 정보 없음", new ArrayList<CategoryDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "보고서 정보 조회", responseRepairDto), HttpStatus.OK);
    }

    @PostMapping("/review/create")
    public ResponseEntity<MsgDto> createReview(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                               @RequestBody RequestReviewCreateDto requestReviewCreateDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        boolean result = reviewService.createReview(requestReviewCreateDto, memberId);
        if(result) {
            return new ResponseEntity<>(new MsgDto(true, "리뷰 작성 성공", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "리뷰 중복된 리뷰 작성", null), HttpStatus.OK);
    }

    @GetMapping("/review/list")
    public ResponseEntity<MsgDto> getReviews(@RequestParam int page, @RequestParam Long shopId) {
        Page<RepairServiceReviewDto> reviews = reviewService.getReviews(page, shopId);
        if(reviews.getTotalElements() == 0) {
            return new ResponseEntity<>(new MsgDto(false, "리뷰 없음", reviews.getContent()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "리뷰 조회", reviews), HttpStatus.OK);
    }



    @GetMapping("/review")
    public ResponseEntity<MsgDto> getReview(@RequestParam Long reviewId) {
        RepairServiceReviewDto review = reviewService.getReview(reviewId);
        if(review == null) {
            return new ResponseEntity<>(new MsgDto(false, "리뷰 없음", new ArrayList<CategoryDto>()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(true, "리뷰 조회", review), HttpStatus.OK);
    }

    @PutMapping("/review/update")
    public ResponseEntity<MsgDto> updateReview(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                               @RequestBody RequestReviewUpdateDto requestReviewUpdateDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        System.out.println("requestReviewUpdateDto = " + requestReviewUpdateDto);
        boolean result = reviewService.updateReview(requestReviewUpdateDto, memberId);
        if(result) {
            return new ResponseEntity<>(new MsgDto(true, "리뷰 수정 성공", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "리뷰 수정 실패", null), HttpStatus.OK);
    }

    @DeleteMapping("/review/delete")
    public ResponseEntity<MsgDto> deleteReview(Long reviewId) {
        boolean result = reviewService.deleteReview(reviewId);
        if(result) {
            return new ResponseEntity<>(new MsgDto(true, "리뷰 삭제 성공", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "리뷰 삭제 실패", null), HttpStatus.OK);
    }

    @PostMapping("/reply/create")
    public ResponseEntity<MsgDto> createReply(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                               @RequestBody RequestReplyCreateDto requestReplyCreateDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        System.out.println("requestReplyCreateDto = " + requestReplyCreateDto);
        boolean result = reviewService.createReply(requestReplyCreateDto, memberId);
        if(result) {
            return new ResponseEntity<>(new MsgDto(true, "답글 생성 성공", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "답글 생성 실패", null), HttpStatus.OK);
    }

    @PutMapping("/reply/update")
    public ResponseEntity<MsgDto> updateReply(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken,
                                               @RequestBody RequestReplyUpdateDto requestReplyUpdateDto) {
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        boolean result = reviewService.updateReply(requestReplyUpdateDto, memberId);
        if(result) {
            return new ResponseEntity<>(new MsgDto(true, "답글 수정 성공", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "답글 수정 실패", null), HttpStatus.OK);
    }



    @DeleteMapping("/reply/delete")
    public ResponseEntity<MsgDto> deleteReply(@RequestHeader(value = "X-AUTH-TOKEN") String accessToken, Long replyId) {
        System.out.println("replyId = " + replyId);
        Long memberId = Long.valueOf(tokenProvider.getId(tokenProvider.resolveToken(accessToken)));
        boolean result = reviewService.deleteReply(replyId, memberId);
        if(result) {
            return new ResponseEntity<>(new MsgDto(true, "답글 삭제 성공", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MsgDto(false, "답글 삭제 실패", null), HttpStatus.OK);
    }
}


