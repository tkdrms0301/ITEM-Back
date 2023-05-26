package kit.item.repository.data;

import kit.item.domain.data.Data;
import kit.item.dto.entity.data.DataDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
    @Query("select new kit.item.dto.entity.data.DataDto(d.vocab, d.count) from DATA d where d.product.id =:productId")
    List<DataDto> getDataListByProductId(@Param(value = "productId") Long productId);
}
