package kit.item.service.repairShop;

import kit.item.domain.member.Member;
import kit.item.domain.member.RepairShop;
import kit.item.domain.repair.RepairServiceReply;
import kit.item.domain.repair.RepairServiceReplyReport;
import kit.item.domain.repair.RepairServiceReview;
import kit.item.domain.repair.RepairServiceReviewReport;
import kit.item.dto.entity.repairShop.RepairServiceReviewDto;
import kit.item.dto.request.repair.*;
import kit.item.repository.member.MemberRepository;
import kit.item.repository.repairShop.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static kit.item.util.prefix.ConstData.REPORT_COUNT;
import static kit.item.util.prefix.ConstString.REPORT_REPLY;
import static kit.item.util.prefix.ConstString.REPORT_REVIEW;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewService {
    private static final int PAGE_SIZE = 10;
    private final RepairServiceReviewRepository repairServiceReviewRepository;
    private final RepairServiceReplyRepository repairServiceReplyRepository;
    private final RepairShopRepository repairShopRepository;
    private final RepairServiceReviewReportRepository repairServiceReviewReportRepository;
    private final RepairServiceReplyReportRepository repairServiceReplyReportRepository;
    private final MemberRepository memberRepository;

    public RepairServiceReviewDto createReview(RequestReviewCreateDto requestReviewCreateDto, Long memberId) {
        Optional<RepairShop> repairShop = repairShopRepository.findById(requestReviewCreateDto.getRepairShopId());
        if (repairShop.isEmpty()) {
            return null;
        }
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            return null;
        }
        if (repairShop.get().getId().equals(memberId)) {
            return null;
        }
        RepairServiceReview repairServiceReview = RepairServiceReview.builder()
                .content(requestReviewCreateDto.getContent())
                .rating(requestReviewCreateDto.getRating())
                .member(member.get())
                .repairShop(repairShop.get())
                .build();
        repairServiceReviewRepository.save(repairServiceReview);
        Optional<RepairServiceReview> createdReview = repairServiceReviewRepository.findById(repairServiceReview.getId());
        if (createdReview.isEmpty()) {
            return null;
        }
        return RepairServiceReviewDto.builder()
                .reviewId(createdReview.get().getId())
                .reviewContent(createdReview.get().getContent())
                .rating(createdReview.get().getRating())
                .replyId(createdReview.get().getRepairServiceReply() != null ? createdReview.get().getRepairServiceReply().getId() : null)
                .replyContent(createdReview.get().getRepairServiceReply() != null ? createdReview.get().getRepairServiceReply().getContent() : null)
                .repairShopNickname(createdReview.get().getRepairShop().getNickname())
                .userNickname(createdReview.get().getMember().getNickname())
                .build();
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

    public RepairServiceReviewDto updateReview(RequestReviewUpdateDto requestReviewUpdateDto, Long memberId) {
        Optional<RepairServiceReview> repairServiceReview = repairServiceReviewRepository.findById(requestReviewUpdateDto.getReviewId());
        if (repairServiceReview.isEmpty()) {
            return null;
        }
        if (!repairServiceReview.get().getMember().getId().equals(memberId)) {
            return null;
        }
        repairServiceReview.get().setContent(requestReviewUpdateDto.getContent());
        repairServiceReview.get().setRating(requestReviewUpdateDto.getRating());
        RepairServiceReview savedReview = repairServiceReview.get();
        repairServiceReviewRepository.save(savedReview);
        Optional<RepairServiceReview> updatedReview = repairServiceReviewRepository.findById(savedReview.getId());
        if (updatedReview.isEmpty()) {
            return null;
        }
        return RepairServiceReviewDto.builder()
                .reviewId(updatedReview.get().getId())
                .reviewContent(updatedReview.get().getContent())
                .rating(updatedReview.get().getRating())
                .replyId(updatedReview.get().getRepairServiceReply() != null ? updatedReview.get().getRepairServiceReply().getId() : null)
                .replyContent(updatedReview.get().getRepairServiceReply() != null ? updatedReview.get().getRepairServiceReply().getContent() : null)
                .repairShopNickname(updatedReview.get().getRepairShop().getNickname())
                .userNickname(updatedReview.get().getMember().getNickname())
                .build();
    }

    public boolean deleteReview(Long memberId, Long reviewId) {
        Optional<RepairServiceReview> repairServiceReview = repairServiceReviewRepository.findByIdAndMember_Id(reviewId, memberId);
        if (repairServiceReview.isEmpty()) {
            return false;
        }
        RepairServiceReply repairServiceReply = repairServiceReview.get().getRepairServiceReply();
        if (repairServiceReply != null) {
            List<RepairServiceReplyReport> replyReports = repairServiceReplyReportRepository.findAllByRepairServiceReplyId(repairServiceReply.getId());
            if (!replyReports.isEmpty()) {
                repairServiceReplyReportRepository.deleteAll(replyReports);
            }
            repairServiceReplyRepository.delete(repairServiceReply);
        }
        List<RepairServiceReviewReport> repairServiceReviewReports = repairServiceReviewReportRepository.findAllByRepairServiceReviewId(reviewId);
        if (!repairServiceReviewReports.isEmpty()) {
            repairServiceReviewReportRepository.deleteAll(repairServiceReviewReports);
        }
        repairServiceReviewRepository.delete(repairServiceReview.get());
        return true;
    }

    public RepairServiceReviewDto createReply(RequestReplyCreateDto requestReplyCreateDto, Long memberId) {
        Optional<RepairServiceReview> review = repairServiceReviewRepository.findById(requestReplyCreateDto.getReviewId());
        if (review.isEmpty()) {
            return null;
        }
        Optional<RepairShop> repairShop = repairShopRepository.findById(memberId);
        if (repairShop.isEmpty()) {
            return null;
        }
        Optional<RepairServiceReply> reply = repairServiceReplyRepository.findByRepairServiceReviewId(requestReplyCreateDto.getReviewId());
        if (reply.isPresent()) {
            return null;
        }
        RepairServiceReply repairServiceReply = RepairServiceReply.builder()
                .content(requestReplyCreateDto.getContent())
                .repairServiceReview(review.get())
                .repairShop(repairShop.get())
                .build();
        repairServiceReplyRepository.save(repairServiceReply);
        Optional<RepairServiceReview> createdReply = repairServiceReviewRepository.findById(repairServiceReply.getRepairServiceReview().getId());
        if (createdReply.isEmpty()) {
            return null;
        }

        return RepairServiceReviewDto.builder()
                .reviewId(createdReply.get().getId())
                .reviewContent(createdReply.get().getContent())
                .rating(createdReply.get().getRating())
                .replyId(repairServiceReply.getId())
                .replyContent(repairServiceReply.getContent())
                .repairShopNickname(createdReply.get().getRepairShop().getNickname())
                .userNickname(createdReply.get().getMember().getNickname())
                .build();
    }

    public RepairServiceReviewDto updateReply(RequestReplyUpdateDto requestReplyUpdateDto, Long memberId) {
        Optional<RepairServiceReply> repairServiceReply = repairServiceReplyRepository.findById(requestReplyUpdateDto.getReviewId());
        if (repairServiceReply.isEmpty()) {
            return null;
        }
        if (!repairServiceReply.get().getRepairShop().getId().equals(memberId)) {
            return null;
        }
        RepairServiceReply savedReply = repairServiceReply.get();
        savedReply.setContent(requestReplyUpdateDto.getContent());
        repairServiceReplyRepository.save(savedReply);
        Optional<RepairServiceReview> updatedReply = repairServiceReviewRepository.findById(requestReplyUpdateDto.getReviewId());
        if (updatedReply.isEmpty()) {
            return null;
        }
        RepairServiceReview savedReview = updatedReply.get();
        return RepairServiceReviewDto.builder()
                .reviewId(savedReview.getId())
                .reviewContent(savedReview.getContent())
                .rating(savedReview.getRating())
                .replyId(savedReply.getId())
                .replyContent(savedReply.getContent())
                .repairShopNickname(savedReview.getRepairShop().getNickname())
                .userNickname(savedReview.getMember().getNickname())
                .build();
    }

    public boolean deleteReply(Long replyId, Long memberId) {
        Optional<RepairServiceReply> repairServiceReply = repairServiceReplyRepository.findById(replyId);
        if (repairServiceReply.isEmpty()) {
            return false;
        }
        if (!repairServiceReply.get().getRepairShop().getId().equals(memberId)) {
            return false;
        }
        List<RepairServiceReplyReport> replyReports = repairServiceReplyReportRepository.findAllByRepairServiceReplyId(repairServiceReply.get().getId());
        if (!replyReports.isEmpty()) {
            repairServiceReplyReportRepository.deleteAll(replyReports);
        }
        repairServiceReplyRepository.delete(repairServiceReply.get());
        return true;
    }

    public boolean createReviewReport(RequestReviewReportDto requestReviewReportDto, Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            return false;
        }
        Optional<RepairServiceReview> repairServiceReview = repairServiceReviewRepository.findById(requestReviewReportDto.getReviewId());
        if (repairServiceReview.isEmpty()) {
            return false;
        }
        Optional<RepairServiceReviewReport> getReview = repairServiceReviewReportRepository.findByRepairServiceReviewIdAndMemberId(requestReviewReportDto.getReviewId(), memberId);
        if (getReview.isPresent()) {
            return false;
        }

        repairServiceReviewReportRepository.save(RepairServiceReviewReport.builder()
                .reason(requestReviewReportDto.getReason())
                .reportType(requestReviewReportDto.getReportType())
                .member(member.get())
                .repairServiceReview(repairServiceReview.get())
                .build());

        if (repairServiceReviewReportRepository.countByRepairServiceReviewIdAndMemberId(requestReviewReportDto.getReviewId(), memberId) > REPORT_COUNT) {
            RepairServiceReview reportedRepairServiceReview = repairServiceReview.get();
            reportedRepairServiceReview.setContent(REPORT_REVIEW);
            repairServiceReviewRepository.save(reportedRepairServiceReview);
        }
        return true;
    }

    public boolean createReplyReport(RequestReplyReportDto requestReplyReportDto, Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            return false;
        }
        Optional<RepairServiceReview> repairServiceReview = repairServiceReviewRepository.findById(requestReplyReportDto.getReplyId());
        if (repairServiceReview.isEmpty()) {
            return false;
        }
        Optional<RepairServiceReply> getReply = repairServiceReplyRepository.findById(requestReplyReportDto.getReplyId());
        if (getReply.isEmpty()) {
            return false;
        }

        repairServiceReplyReportRepository.save(RepairServiceReplyReport.builder()
                .reason(requestReplyReportDto.getReason())
                .reportType(requestReplyReportDto.getReportType())
                .member(member.get())
                .repairServiceReply(getReply.get())
                .build());

        if (repairServiceReplyReportRepository.countByRepairServiceReplyIdAndMemberId(requestReplyReportDto.getReplyId(), memberId) > REPORT_COUNT) {
            RepairServiceReply reportedRepairServiceReply = getReply.get();
            reportedRepairServiceReply.setContent(REPORT_REPLY);
            repairServiceReplyRepository.save(reportedRepairServiceReply);
        }
        return true;
    }
}
