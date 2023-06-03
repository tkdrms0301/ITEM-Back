package kit.item.repository.repairShop;

import kit.item.domain.repair.RepairServiceReplyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairServiceReplyReportRepository extends JpaRepository<RepairServiceReplyReport, Long> {
    @Query("SELECT COUNT(r) FROM REPAIR_SERVICE_REPLY_REPORT r " +
            "WHERE r.id = :replyId AND r.member.id = :memberId")
    int countByRepairServiceReplyIdAndMemberId(@Param(value = "replyId") Long replyId, @Param(value = "memberId") Long memberId);
}
