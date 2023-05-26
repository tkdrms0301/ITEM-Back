package kit.item.repository.data;

import kit.item.domain.data.Data;
import kit.item.dto.entity.data.DataDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
    @Query("select new kit.item.dto.entity.data.DataDto(d.vocab, d.count, d.product.id) from DATA d where d.vocab like %:word%")
    Page<DataDto> getDataListByWord(@Param(value = "word") String word, Pageable pageable);

    @Query("select new kit.item.dto.entity.data.DataDto(d.vocab, d.count, d.product.id) from DATA d where d.product.id =:productId")
    Page<DataDto> getDataListByProductId(@Param(value = "productId") Long productId, Pageable pageable);

}
