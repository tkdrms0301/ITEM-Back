package kit.item.repository.data;

import kit.item.domain.data.Data;
import kit.item.dto.entity.data.DataDto;
import kit.item.dto.entity.data.DataResultDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
    @Query("select new kit.item.dto.entity.data.DataDto(d.id, d.vocab, d.count) from DATA d where d.product.id =:productId order by d.count desc ")
    List<DataDto> getDataListByProductId(@Param(value = "productId") Long productId);

    @Query("select new kit.item.dto.entity.data.DataDto(d.id, d.vocab, d.count) from DATA d where d.vocab =:vocab order by d.count desc")
    Page<DataDto> getDataListByVocab(@Param(value = "vocab") String vocab, Pageable pageable);

    Page<Data> findAllByVocab(String vocab, Pageable pageable);
}
