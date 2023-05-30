package kit.item.repository.data;

import kit.item.domain.data.PosAndNeg;
import kit.item.dto.entity.data.PosAndNegDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PosAndNegRepository extends JpaRepository<PosAndNeg, Long> {
    @Query("select new kit.item.dto.entity.data.PosAndNegDto(pan.positive, pan.negative) from POS_AND_NEG pan where pan.product.id =:productId")
    PosAndNegDto getPosAndNegByProductId(@Param(value = "productId") Long productId);
}
