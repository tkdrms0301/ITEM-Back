package kit.item.repository;

import kit.item.domain.point.PointHistory;
import kit.item.dto.entity.point.PointHistoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<PointHistory, Long> {

    @Query("select new kit.item.dto.entity.point.PointHistoryDto(p.id, p.date, p.point, p.serviceName, p.serviceType) from POINT_HISTORY p where p.member.id=:id")
    List<PointHistoryDto> findPointHistoryByMemberId(@Param("id") Long id);


}
