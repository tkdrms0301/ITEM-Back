package kit.item.service.repairShop;

import kit.item.domain.member.Member;
import kit.item.domain.member.RepairShop;
import kit.item.domain.post.Post;
import kit.item.domain.repair.RepairServiceReply;
import kit.item.domain.repair.RepairServiceReview;
import kit.item.dto.entity.community.PostDto;
import kit.item.dto.entity.repairShop.RepairServiceReplyDto;
import kit.item.dto.entity.repairShop.RepairServiceReviewDto;
import kit.item.dto.request.repair.RequestReplyCreateDto;
import kit.item.dto.request.repair.RequestReplyUpdateDto;
import kit.item.dto.request.repair.RequestReviewCreateDto;
import kit.item.dto.request.repair.RequestReviewUpdateDto;
import kit.item.dto.response.community.ResponsePostListDto;
import kit.item.dto.response.repairShop.ResponseRepairServiceReviewDto;
import kit.item.repository.member.MemberRepository;
import kit.item.repository.repairShop.RepairServiceReplyRepository;
import kit.item.repository.repairShop.RepairServiceReviewRepository;
import kit.item.repository.repairShop.RepairShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewService {
    private static final int PAGE_SIZE = 10;
    private final RepairServiceReviewRepository repairServiceReviewRepository;
    private final RepairServiceReplyRepository repairServiceReplyRepository;
    private final RepairShopRepository repairShopRepository;
    private final MemberRepository memberRepository;

    public boolean createReview(RequestReviewCreateDto requestReviewCreateDto, Long memberId) {
        Optional<RepairShop> repairShop = repairShopRepository.findById(requestReviewCreateDto.getRepairShopId());
        if (repairShop.isEmpty()) {
            return false;
        }
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            return false;
        }
//        if (repairServiceReviewRepository.existsByMemberIdAndRepairShopId(memberId, requestReviewCreateDto.getRepairShopId())) {
//            return false;
//        }
        // 정비 예약한 결과 date + 3일 이내로 리뷰 작성 가능하도록
        repairServiceReviewRepository.save(RepairServiceReview.builder()
                    .content(requestReviewCreateDto.getContent())
                    .rating(requestReviewCreateDto.getRating())
                    .member(member.get())
                    .repairShop(repairShop.get())
                    .build());
        return true;
    }

    public Page<RepairServiceReviewDto> getReviews(int page, Long shopId) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE, Sort.by("id").descending());
        return repairServiceReviewRepository.findAllByRepairShopId(shopId, pageable);
    }

    public RepairServiceReviewDto getReview(Long reviewId) {
        Optional<RepairServiceReview> repairServiceReview = repairServiceReviewRepository.findById(reviewId);
        if (repairServiceReview.isEmpty()) {
            return null;
        }
        if (repairServiceReview.get().getRepairServiceReply() != null) {
            RepairServiceReply repairServiceReply = repairServiceReview.get().getRepairServiceReply();
            return RepairServiceReviewDto.builder()
                    .reviewId(repairServiceReview.get().getId())
                    .reviewContent(repairServiceReview.get().getContent())
                    .rating(repairServiceReview.get().getRating())
                    .replyId(repairServiceReply.getId())
                    .replyContent(repairServiceReply.getContent())
                    .build();
        }
        return RepairServiceReviewDto.builder()
                .reviewId(repairServiceReview.get().getId())
                .reviewContent(repairServiceReview.get().getContent())
                .rating(repairServiceReview.get().getRating())
                .replyId(null)
                .replyContent(null)
                .build();
    }

    public boolean updateReview(RequestReviewUpdateDto requestReviewUpdateDto, Long memberId) {
        Optional<RepairServiceReview> repairServiceReview = repairServiceReviewRepository.findById(requestReviewUpdateDto.getReviewId());
        if (repairServiceReview.isEmpty()) {
            return false;
        }
        if (!repairServiceReview.get().getMember().getId().equals(memberId)) {
            return false;
        }
        repairServiceReview.get().setContent(requestReviewUpdateDto.getContent());
        repairServiceReview.get().setRating(requestReviewUpdateDto.getRating());
        repairServiceReviewRepository.save(repairServiceReview.get());
        return true;
    }

    public boolean deleteReview(Long reviewId) {
        Optional<RepairServiceReview> repairServiceReview = repairServiceReviewRepository.findById(reviewId);
        if (repairServiceReview.isEmpty()) {
            return false;
        }
        RepairServiceReply repairServiceReply = repairServiceReview.get().getRepairServiceReply();
        if (repairServiceReply != null) {
            repairServiceReplyRepository.delete(repairServiceReply);
        }
        repairServiceReviewRepository.delete(repairServiceReview.get());
        return true;
    }

    public boolean createReply(RequestReplyCreateDto requestReplyCreateDto, Long memberId) {
        Optional<RepairServiceReview> review = repairServiceReviewRepository.findById(requestReplyCreateDto.getReviewId());
        if (review.isEmpty()) {
            return false;
        }
        Optional<RepairShop> repairShop = repairShopRepository.findById(memberId);
        if (repairShop.isEmpty()) {
            return false;
        }
        repairServiceReplyRepository.save(RepairServiceReply.builder()
                        .content(requestReplyCreateDto.getContent())
                        .repairServiceReview(review.get())
                        .repairShop(repairShop.get())
                        .build());
        return true;
    }

    public boolean updateReply(RequestReplyUpdateDto requestReplyUpdateDto, Long memberId) {
        Optional<RepairServiceReply> repairServiceReply = repairServiceReplyRepository.findById(requestReplyUpdateDto.getReviewId());
        if (repairServiceReply.isEmpty()) {
            return false;
        }
        if (!repairServiceReply.get().getRepairShop().getId().equals(memberId)) {
            return false;
        }
        repairServiceReply.get().setContent(requestReplyUpdateDto.getContent());
        repairServiceReplyRepository.save(repairServiceReply.get());
        return true;
    }

    public boolean deleteReply(Long replyId, Long memberId) {
        Optional<RepairServiceReply> repairServiceReply = repairServiceReplyRepository.findById(replyId);
        if (repairServiceReply.isEmpty()) {
            return false;
        }
        if (!repairServiceReply.get().getRepairShop().getId().equals(memberId)) {
            return false;
        }
        repairServiceReplyRepository.delete(repairServiceReply.get());
        return true;
    }

    public boolean createReviewReport(Long reviewId) {
        return false;
    }

    public boolean createReplyReport(Long replyId) {
        return false;
    }

    public boolean getReviewList(Long repairShopId) {
        return false;
    }


}
