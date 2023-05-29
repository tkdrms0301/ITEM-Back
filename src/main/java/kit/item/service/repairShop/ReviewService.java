package kit.item.service.repairShop;

import kit.item.domain.member.Member;
import kit.item.domain.member.RepairShop;
import kit.item.domain.repair.RepairServiceReview;
import kit.item.dto.request.repair.RequestReplyCreateDto;
import kit.item.dto.request.repair.RequestReviewCreateDto;
import kit.item.dto.request.repair.RequestReviewUpdateDto;
import kit.item.repository.member.MemberRepository;
import kit.item.repository.repairShop.RepairServiceReplyRepository;
import kit.item.repository.repairShop.RepairServiceReviewRepository;
import kit.item.repository.repairShop.RepairShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewService {
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
        repairServiceReviewRepository.save(RepairServiceReview.builder()
                    .content(requestReviewCreateDto.getContent())
                    .rating(requestReviewCreateDto.getRating())
                    .member(member.get())
                    .repairShop(repairShop.get())
                    .build());
        return true;
    }

    public boolean getReview(Long shopId) {
        return false;
    }

    public boolean getReview(Long shopId, Long reviewId) {
        return false;
    }

    public boolean updateReview(RequestReviewUpdateDto requestReviewUpdateDto, Long memberId) {
        Optional<RepairServiceReview> repairServiceReview = repairServiceReviewRepository.findByRepairShopIdAndMemberId(requestReviewUpdateDto.getRepairShopId(), memberId);
        if (repairServiceReview.isEmpty()) {
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
        repairServiceReviewRepository.delete(repairServiceReview.get());
        return true;
    }

    public boolean createReply(RequestReplyCreateDto requestReplyCreateDto) {
        return false;
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
