package kit.item.repository.point;

import kit.item.domain.point.PointHistory;
import kit.item.dto.entity.point.PointHistoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<PointHistory, Long> {

    @Query("select new kit.item.dto.entity.point.PointHistoryDto(p.id, p.date, p.point, p.serviceName, p.serviceType) from POINT_HISTORY p where p.member.id = :id order by p.date desc")
    List<PointHistoryDto> findPointHistoryByMemberId(@Param("id") Long id);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM POINT_HISTORY p WHERE p.member.id = :memberId AND p.id = :historyId")
    boolean existsByMemberIdAndHistoryId(@Param("memberId") Long memberId, @Param("historyId") Long historyId);

    @Query("select new kit.item.dto.entity.point.PointHistoryDto(p.id, p.date, p.point, p.serviceName, p.serviceType) " +
            "from POINT_HISTORY p " +
            "where p.member.id = :memberId " +
            "and p.date >= :startDate " +
            "and p.date <= :endDate " +
            "order by p.date desc")
    List<PointHistoryDto> findPointHistoryByMemberIdAndDateRange(
            @Param("memberId") Long memberId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    @Override
    void deleteById(Long aLong);

    @Query("select new kit.item.dto.entity.point.PointHistoryDto(p.id, p.date, p.point, p.serviceName, p.serviceType) from POINT_HISTORY p where p.serviceType = '수리 서비스 제공' AND p.member.id = :id order by p.date desc")
    List<PointHistoryDto> findIncomeHistoryByMemberId(@Param("id") Long id);


    @Query("SELECT new kit.item.dto.entity.point.PointHistoryDto(p.id, p.date, p.point, p.serviceName, p.serviceType) " +
            "FROM POINT_HISTORY p " +
            "WHERE p.member.id = :memberId " +
            "AND p.serviceType = '수리 서비스 제공'" +
            "AND p.serviceName IN :serviceNames " +
            "AND p.date >= :startDate " +
            "AND p.date <= :endDate " +
            "ORDER BY p.date DESC")
    List<PointHistoryDto> findIncomeHistoryByMemberIdAndServiceNamesAndDateRange(
            @Param("memberId") Long memberId,
            @Param("serviceNames") List<String> serviceNames,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
}
